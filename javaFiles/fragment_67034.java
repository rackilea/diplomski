private static final byte[] KEY_DATA = {
    (byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03,
    (byte) 0x04, (byte) 0x05, (byte) 0x06, (byte) 0x07,
    (byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0B,
    (byte) 0x0C, (byte) 0x0D, (byte) 0x0E, (byte) 0x0F,
};

private static final byte[] IV_DATA = {
    (byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03,
    (byte) 0x04, (byte) 0x05, (byte) 0x06, (byte) 0x07,
    (byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0B,
    (byte) 0x0C, (byte) 0x0D, (byte) 0x0E, (byte) 0x0F,
};

public static void main(String[] args) throws Exception {
    Cipher aes = Cipher.getInstance("AES/CBC/PKCS5Padding");

    SecretKey key = new SecretKeySpec(KEY_DATA, "aes");
    IvParameterSpec iv = new IvParameterSpec(IV_DATA);

    aes.init(Cipher.ENCRYPT_MODE, key, iv);

    ...
}