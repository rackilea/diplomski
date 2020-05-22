public static ar.edu.ues21.menu.util.EncryptedData encrypt2(String key, String data) throws Exception {
    ar.edu.ues21.menu.util.EncryptedData result =  null;
    BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new RijndaelEngine(128)), new ZeroBytePadding());

    byte[] iv = new byte[16];        
    SecureRandom.getInstance("SHA1PRNG").nextBytes(iv);

    CipherParameters ivAndKey = new ParametersWithIV(new KeyParameter(key.getBytes("UTF-8")), iv);        
    cipher.init(true, ivAndKey);

    byte[] input = data.getBytes("UTF-8");
    byte[] cipherText = new byte[cipher.getOutputSize(input.length)];

    int cipherLength = cipher.processBytes(input, 0, input.length, cipherText, 0);
    cipher.doFinal(cipherText, cipherLength);

    result = new ar.edu.ues21.menu.util.EncryptedData(Base64.encodeBase64String(iv), Base64.encodeBase64String(cipherText));
    return result;
}