public static byte[] wrapKey(PublicKey pubKey, SecretKey symKey)
        throws InvalidKeyException, IllegalBlockSizeException {
    try {
        final Cipher cipher = Cipher
                .getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
        cipher.init(Cipher.WRAP_MODE, pubKey);
        final byte[] wrapped = cipher.wrap(symKey);
        return wrapped;
    } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
        throw new IllegalStateException(
                "Java runtime does not support RSA/ECB/OAEPWithSHA1AndMGF1Padding",
                e);
    }
}