//your message
    String message = "Hello World!";
    //generate a new AES key. (an AES key is just a random sequence 16 bytes)
    SecureRandom random = new SecureRandom();
    byte[] aesKey = new byte[16];
    random.nextBytes(aesKey);
    //generate a new initialization vector (iv) which is also a random sequence of 16 bytes.
    byte[] iv = new byte[16];
    random.nextBytes(iv);

    String aesKeyAsString = Base64.getEncoder().encodeToString(aesKey);
    String ivAsString = Base64.getEncoder().encodeToString(iv);
    //encrypt
    byte[] encrypted = encrypt(message, aesKeyAsString, ivAsString);
    //enocde your encrypted byte[] to String
    String encryptedString = Base64.getEncoder().encodeToString(encrypted);
    //decrypt
    String decrypted = decrypt(encryptedString, aesKeyAsString, ivAsString);
    //print your results
    System.out.println("Encrypted: " + encryptedString + " Decrypted: " + decrypted);