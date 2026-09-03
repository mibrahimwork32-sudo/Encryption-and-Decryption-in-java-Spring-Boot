package com.Encryptiondemo.encryptiondecryption.demo.services;

import com.Encryptiondemo.encryptiondecryption.demo.models.readData;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

@Service
public class encryption {
    private final keyGenerator keyGenerator;
    readData readData = new readData();

    public encryption(keyGenerator keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    public String encrypt()throws Exception {
        Cipher cipher;
        readData.getoriginal();
        SecretKey key = keyGenerator.getKey();
                cipher = Cipher.getInstance("AES");
                cipher.init(cipher.ENCRYPT_MODE,key);
                byte[] encryptbytes = cipher.doFinal(readData.getoriginal().getBytes());
                String readablecipher = Base64.getEncoder().encodeToString(encryptbytes);
                 Files.writeString(Path.of("C:\\Users\\Public\\Documents\\INTERNSHP PROJECTS INTELIJ\\encryptiondecryption-demo\\Encrypteddata.txt"),readablecipher);
                  return readablecipher;
    }
}
