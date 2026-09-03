package com.Encryptiondemo.encryptiondecryption.demo.models;

import java.nio.file.Files;
import java.nio.file.Path;

public class readData {

    //Read original data
    public String getoriginal()throws Exception {
    String original = Files.readString(Path.of("C:\\Users\\Public\\Documents\\INTERNSHP PROJECTS INTELIJ\\encryptiondecryption-demo\\originaldata.txt"));
    return original;
    }
    //read Encrypted data
    public String getencrypted()throws Exception {
        String Encrypt = Files.readString(Path.of("C:\\Users\\Public\\Documents\\INTERNSHP PROJECTS INTELIJ\\encryptiondecryption-demo\\Encrypteddata.txt"));
        return Encrypt;
    }

}
