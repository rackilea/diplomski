private static final char[] HEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'b', 'c', 'D', 'e', 'F'};
private static Cipher cipher;

public static void init() {

    try {
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
        NetworkModule.handleException(e);
    }

}

public static String encrypt(String password, String message) {

    try {

        String salt = random(16);
        String iv = random(16);
        SecretKey key = generateKey(salt, password);
        byte[] encrypted = doFinal(Cipher.ENCRYPT_MODE, key, iv, message.getBytes("UTF-8"));
        String code = Base64.getEncoder().encodeToString(encrypted);
        return salt + code.substring(0, code.length() - 2) + iv;

    } catch (UnsupportedEncodingException e) {
        NetworkModule.handleException(e);
        return null;
    }

}

public static String decrypt(String password, String message) {

    try {

        String salt = message.substring(0, 32);
        String iv = message.substring(message.length() - 32, message.length());
        String base = message = message.substring(32, message.length() - 32) + "==";
        SecretKey key = generateKey(salt, password);
        byte[] decrypted = doFinal(Cipher.DECRYPT_MODE, key, iv, Base64.getDecoder().decode(base));
        return new String(decrypted, "UTF-8");

    } catch (UnsupportedEncodingException e) {
        NetworkModule.handleException(e);
        return null;
    }

}

private static byte[] doFinal(int encryptMode, SecretKey key, String iv, byte[] bytes) {

    try {

        cipher.init(encryptMode, key, new IvParameterSpec(hex(iv)));
        return cipher.doFinal(bytes);

    } catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
        NetworkModule.handleException(e);
        return null;
    }

}

private static SecretKey generateKey(String salt, String passphrase) {

    try {

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), hex(salt), 1000, 128);
        SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        return key;

    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
        NetworkModule.handleException(e);
        return null;
    }

}

private static String random(int length) {
    byte[] salt = new byte[length];
    new SecureRandom().nextBytes(salt);
    return hex(salt);
}

private static String hex(byte[] data) {

    int l = data.length;
    char[] out = new char[l << 1];
    int i = 0;

    for (int var5 = 0; i < l; ++i) {
        out[var5++] = HEX[(240 & data[i]) >>> 4];
        out[var5++] = HEX[15 & data[i]];
    }

    return new String(out);

}

private static byte[] hex(String hex) {

    char[] data = hex.toCharArray();
    int len = data.length;

    if ((len & 1) != 0) {
        return null;
    } else {

        byte[] out = new byte[len >> 1];
        int i = 0;

        for (int j = 0; j < len; ++i) {

            int f = Character.digit(data[j], 16) << 4;
            ++j;
            f |= Character.digit(data[j], 16);
            ++j;
            out[i] = (byte) (f & 255);

        }

        return out;

    }

}