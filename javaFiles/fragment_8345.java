public static SecretKey generateKey(String password) {
    try {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        byte saltBytes[] = new byte[20];
        secureRandom.nextBytes(saltBytes);

        KeySpec spec = new PBEKeySpec(password.toCharArray(), saltBytes, 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey secretKey = factory.generateSecret(spec);

        return new SecretKeySpec(secretKey.getEncoded(), "AES");
    } catch (Exception e) {
        throw new IllegalStateException("Key cant be generated !");
    }
}