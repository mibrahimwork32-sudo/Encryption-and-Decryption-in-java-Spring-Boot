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

        // get the same AES key
        SecretKey key = keyGenerator.getKey();

        // create AES cipher
        Cipher cipher = Cipher.getInstance("AES");

        // tell cipher that we want to decrypt
        cipher.init(Cipher.DECRYPT_MODE, key);

        // read Base64 encrypted text from file
        String encryptedData = readData.getencrypted();

        // convert Base64 text back into encrypted bytes
        byte[] encryptedBytes =
                Base64.getDecoder().decode(encryptedData);

        // decrypt the encrypted bytes
        byte[] decryptedBytes =
                cipher.doFinal(encryptedBytes);

        // convert decrypted bytes back into normal text
        String decryptedData =
                new String(decryptedBytes);

        // save decrypted data into a different file
        Files.writeString(
                Path.of("C:\\Users\\Public\\Documents\\INTERNSHP PROJECTS INTELIJ\\encryptiondecryption-demo\\Decrypteddata.txt"),
                decryptedData
        );

        // return original data
        return decryptedData;
    }
}