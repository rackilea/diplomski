private static byte[] encrypt(String plain, String key) throws Exception {
    byte[] clean = plain.getBytes();

    int ivSize = 16;
    byte[] iv = new byte[ivSize];
    SecureRandom random = new SecureRandom();
    random.nextBytes(iv);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    digest.update(key.getBytes("UTF-8"));
    byte[] keyBytes = new byte[16];
    System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
    SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
    byte[] encrypted = cipher.doFinal(clean);

    byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
    System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
    System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);

    return encryptedIVAndText;
}