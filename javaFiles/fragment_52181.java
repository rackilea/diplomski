public static String byteArrayToHex(byte[] bytes) throws UnsupportedEncodingException {
    return Hex.encodeHexString(bytes);
}

public static byte[] hexToByteArray(String hex) throws DecoderException {
    return Hex.decodeHex(hex.toCharArray());
}

public String encrypt(String msg) throws NoSuchAlgorithmException,
        InvalidKeyException, UnsupportedEncodingException,
        IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException {
    AEScipher.init(Cipher.ENCRYPT_MODE, AESkey);
    cipherData = AEScipher.doFinal(handleString(msg.getBytes("UTF-8")));

    this.msg = msg;
    encMsg = byteArrayToHex(cipherData);
    return encMsg;
}

public String decrypt(String msg, String hexDecodeKey) throws
        InvalidKeyException, IllegalBlockSizeException,
        BadPaddingException, UnsupportedEncodingException,
        NoSuchAlgorithmException, NoSuchPaddingException, DecoderException {
    SecretKeySpec key = stringToKey(hexDecodeKey);
    AEScipher.init(Cipher.DECRYPT_MODE, key);
    byte[] decryptedData = AEScipher.doFinal(handleString(hexToByteArray(msg)));
    encMsg = msg;
    msg = new String(decryptedData);
    System.out.println(msg);
    return msg;
}