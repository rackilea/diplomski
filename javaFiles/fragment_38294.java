private static final int PBE_ITERATION_COUNT = 10000;
private static final int AES_KEY_LENGTH_BITS = 128;
private static final int HMAC_KEY_LENGTH_BITS = 256;
private static final String PBE_ALGORITHM = "PBKDF2WithHmacSHA1";
private static final int AES_KEY_LENGTH_BYTES = AES_KEY_LENGTH_BITS >> 3;
private static final int HMAC_KEY_LENGTH_BYTES = HMAC_KEY_LENGTH_BITS >> 3;
private static final String CIPHER = "AES";
private static final String HMAC_ALGORITHM = "HMACSHA256";
private static final int MASTER_KEY_LENGTH_BITS = 160; // max for PBKDF2 configured with SHA-1

public static AesHmacKeyPair generateKeyFromPassword(String password, byte[] salt) throws GeneralSecurityException {
    // PrngFixes.fixPrng(); <-- needs to be put back
    //Get enough random bytes for just the master key:
    KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt,
            PBE_ITERATION_COUNT, MASTER_KEY_LENGTH_BITS);
    SecretKeyFactory keyFactory = SecretKeyFactory
            .getInstance(PBE_ALGORITHM);
    byte[] masterKeyBytes = keyFactory.generateSecret(keySpec).getEncoded();

    //Generate the AES key
    byte[] confidentialityKeyBytes = kdf(masterKeyBytes, "ENC", AES_KEY_LENGTH_BYTES);
    SecretKey confidentialityKey = new SecretKeySpec(confidentialityKeyBytes, CIPHER);

    //Generate the HMAC key
    byte[] integrityKeyBytes = kdf(masterKeyBytes, "MAC", HMAC_KEY_LENGTH_BYTES);
    SecretKey integrityKey = new SecretKeySpec(integrityKeyBytes, HMAC_ALGORITHM);

    return new AesHmacKeyPair(confidentialityKey, integrityKey);
}

private static byte[] kdf(byte[] inputKeyMaterial, String label, int outputKeyBytes) {
    try {
        Mac mac = Mac.getInstance("HMACSHA256");
        mac.init(new SecretKeySpec(inputKeyMaterial, "HMACSHA256"));
        mac.update(label.getBytes(StandardCharsets.US_ASCII));
        byte[] confidentialityKeyBytes = mac.doFinal();
        return Arrays.copyOf(confidentialityKeyBytes, outputKeyBytes);
    } catch (NoSuchAlgorithmException | InvalidKeyException e) {
        throw new RuntimeException("HMAC operation doesn't work", e);
    }
}