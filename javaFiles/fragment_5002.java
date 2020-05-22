public static final byte[] readBytes(final InputStream is) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream(Short.MAX_VALUE);
    byte[] b = new byte[Short.MAX_VALUE];
    int len = 0;
    while ((len = is.read(b)) != -1) {
        baos.write(b, 0, len);
    }
    return baos.toByteArray();
}