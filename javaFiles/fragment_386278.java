String dataToEncryptDecrypt = "android";
    String encryptionDecryptionKey = "1234567812345678";
    String ivs = "12345678";

    byte[] encryptedData = encrypt(dataToEncryptDecrypt.getBytes(), encryptionDecryptionKey.getBytes(),
            ivs.getBytes());
    // here you will get the encrypted bytes. Now you can use Base64 encoding on these bytes, before sending to your web-service

    byte[] decryptedData = decrypt(encryptedData, encryptionDecryptionKey.getBytes(), ivs.getBytes());
    System.out.println(new String(decryptedData));