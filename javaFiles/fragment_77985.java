package com.stackoverflow.q2535542;

import java.security.SecureRandom;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;

public class Test {

    public static void main(String[] args) throws Exception {
        // Generate random bytes and show them.
        byte[] bytes = new byte[16];
        SecureRandom.getInstance("SHA1PRNG").nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));

        // Base64-encode bytes and show them.
        String base64String = Base64.encodeBase64String(bytes);
        System.out.println(base64String);

        // Base64-decode string and show bytes.
        byte[] decoded = Base64.decodeBase64(base64String);
        System.out.println(Arrays.toString(decoded));
    }

}