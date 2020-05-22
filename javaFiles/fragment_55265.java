public static String encryptMessageGH(String message, String password) throws Exception {
    MessageDigest sha = MessageDigest.getInstance("SHA-256");
    byte[] key = sha.digest(password.getBytes("UTF-8"));
    SecretKeySpec aesKey = new SecretKeySpec(key, "AES");
    byte[] iv = new byte[16];
    new SecureRandom().nextBytes(iv);
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    cipher.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(iv));
    byte[] ciphertext = cipher.doFinal(message.getBytes());
    byte[] encrypted = new byte[iv.length + ciphertext.length];
    System.arraycopy(iv, 0, encrypted, 0, iv.length);
    System.arraycopy(ciphertext, 0, encrypted, iv.length, ciphertext.length);
    return Base64.getEncoder().encodeToString(encrypted);
}

public static String decryptMessageGH(String encryptedMessage, String password) throws Exception {
    MessageDigest sha = MessageDigest.getInstance("SHA-256");
    byte[] key = sha.digest(password.getBytes("UTF-8"));
    SecretKeySpec aesKey = new SecretKeySpec(key, "AES");
    byte[] encrypted = Base64.getDecoder().decode(encryptedMessage);
    byte[] iv = new byte[16];
    System.arraycopy(encrypted, 0, iv, 0, iv.length);
    byte[] ciphertext = new byte[encrypted.length - iv.length];
    System.arraycopy(encrypted, iv.length, ciphertext, 0, ciphertext.length);
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(iv));
    return new String(cipher.doFinal(ciphertext), "UTF-8");
}

public static void main(String[] args) throws Exception {
    String orig = "Test message";
    String enc = encryptMessageGH(orig, "abcdef123");
    System.out.println("Encrypted: " + enc);
    String dec = decryptMessageGH(enc, "abcdef123");
    System.out.println("Decrypted: " + dec);
}