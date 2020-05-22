private static final java.util.Base64.Decoder BASE_64_DECODER= new java.util.Base64.Decoder();

private static final String ENCODING = "UTF-8";// Use the correct encoding here.

private byte[] decodePassword(char[] password) {
    CharBuffer charBuffer = CharBuffer.wrap(password);
    ByteBuffer byteBuffer = Charset.forName(ENCODING).encode(charBuffer);
    return BASE_64_DECODER.decode(byteBuffer);
}