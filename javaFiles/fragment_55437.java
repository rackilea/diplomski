public static void main(String[] args) throws Exception {
    BufferedBlockCipher cipher = getCipher(PASSWORD, true);
    byte[] inputText = WORD.getBytes("UTF-8");
    byte asd[] = new byte[cipher.getOutputSize(inputText.length)];
    int l = cipher.processBytes(inputText, 0, inputText.length, asd, 0);
    int n = cipher.doFinal(asd, l); // <--- Change to asd
}