public String readStream(InputStream stream, int bufferLength) throws IOException {
    StringBuilder builder = new StringBuilder();
    int read = 0;
    byte[] buffer = new byte[8 * 1024];
    while ((read = stream.read(buffer)) > 0) {
        builder.append(new String(buffer, 0, read));
    }
    return builder.toString();
}