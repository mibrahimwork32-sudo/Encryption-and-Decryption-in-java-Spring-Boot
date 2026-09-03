package com.Encryptiondemo.encryptiondecryption.demo.services;

import com.Encryptiondemo.encryptiondecryption.demo.models.readData;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Service
public class decryption {

    private final keyGenerator keyGenerator;
    private final readData readData = new readData();

    public decryption(keyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    public String decryptdata() throws Exception {

        SecretKey key = keyGenerator.getKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        String encryptedData = readData.getencrypted();
        byte[] encryptedBytes =
                Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes =
                cipher.doFinal(encryptedBytes);
        String decryptedData =
                new String(decryptedBytes);
        Files.writeString(
                Path.of("C:\\Users\\Public\\Documents\\INTERNSHP PROJECTS INTELIJ\\encryptiondecryption-demo\\Decrypteddata.txt"),
                decryptedData
        );
        return decryptedData;
    }
}