KeyGenerator keyGen = KeyGenerator.getInstance("AES");
    keyGen.init(128); // or 256

    // Generate the secret key specs
    SecretKey secretKey = keyGen.generateKey();
    byte[] byteArray = secretKey.getEncoded();