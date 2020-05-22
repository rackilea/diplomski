BlockCipher engine = new AESEngine();
BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(engine));

byte[] key = keyString.getBytes();
byte[] input = inputString.getBytes();

cipher.init(true, new ParametersWithIV(new KeyParameter(key), ivBytes));

byte[] cipherText = new byte[cipher.getOutputSize(input.length)];

int outputLen = cipher.processBytes(input, 0, input.length, cipherText, 0);
try
{
    cipher.doFinal(cipherText, outputLen);
}
catch (CryptoException ce)
{
    System.err.println(ce);
    System.exit(1);
}