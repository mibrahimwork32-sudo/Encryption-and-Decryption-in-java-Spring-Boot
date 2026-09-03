package com.Encryptiondemo.encryptiondecryption.demo.services;

import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
@Service
public class keyGenerator {
    private SecretKey key ;
        public keyGenerator() throws Exception {
        KeyGenerator keyGenerator = null;
        keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        key = keyGenerator.generateKey();

    }
    public SecretKey getKey(){
        return key;
    }
}
