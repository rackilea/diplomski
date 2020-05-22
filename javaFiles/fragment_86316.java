protected static byte[] processCipher(boolean encrypt, int tagLen, byte[] keyBytes, byte[] iv, byte[] in, byte[] ad) throws IllegalStateException, InvalidCipherTextException {
    KeyParameter key = new KeyParameter(keyBytes);
    AEADParameters params = new AEADParameters(key, tagLen, iv);
    AEADBlockCipher cipher = new OCBBlockCipher(new AESEngine(), new AESEngine());
    cipher.init(encrypt, params);

    byte[] out = new byte[cipher.getOutputSize(in.length)];
    if(ad != null) cipher.processAADBytes(ad, 0, ad.length);
    int offset = cipher.processBytes(in, 0, in.length, out, 0);
    offset += cipher.doFinal(out, offset);

    return out;
}