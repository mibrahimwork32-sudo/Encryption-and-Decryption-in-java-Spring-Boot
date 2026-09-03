package com.Encryptiondemo.encryptiondecryption.demo.controllers;

import com.Encryptiondemo.encryptiondecryption.demo.services.decryption;
import com.Encryptiondemo.encryptiondecryption.demo.services.encryption;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class encryptioncontroller {
    private final decryption decryption;
    private final encryption encryption;

    public encryptioncontroller(decryption decryption,encryption encryption){
        this.encryption=encryption;
        this.decryption=decryption;
    }
    @PostMapping("/encryption")
        public String encrypt() throws Exception{
        return encryption.encrypt();
        }

    @PostMapping("/decryption")
    public String decrypt() throws Exception{
        return decryption.decryptdata();
    }
}
