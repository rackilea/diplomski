public static void copyStream(final InputStream inputStream, final OutputStream outputStream, final int bufferLength) throws IOException {
    // copy the input stream to the output stream
    byte[] buf = new byte[bufferLength];
    int len;
    while ((len = inputStream.read(buf)) > 0) {
        outputStream.write(buf, 0, len);
    }
}