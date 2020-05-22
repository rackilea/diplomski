package de.scrum_master.app;

import org.apache.commons.codec.binary.Base64;

public class Application {
    public static void main(String[] args) throws Exception {
        String originalText = "Hello world!";
        System.out.println(originalText);
        byte[] encodedBytes = Base64.encodeBase64(originalText.getBytes());
        String decodedText = new String(Base64.decodeBase64(encodedBytes));
        System.out.println(decodedText);
    }
}