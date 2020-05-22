public static void main(String[] args) {
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword("mySecretPassword");        
    String encryptedText = encryptor.encrypt("Hello World");
    System.out.println("Encrypted text is: " + encryptedText);

    StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
    decryptor.setPassword("mySecretPassword");  
    String decryptedText = decryptor.decrypt(encryptedText);
    System.out.println("Decrypted text is: " + decryptedText);
    }