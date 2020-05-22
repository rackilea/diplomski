void copyLarge(InputStream in, OutputStream out) throws IOException {
    byte[] buffer = new byte[65536];
    int length;
    while ((length = in.read(buffer)) > 0) {
        out.write(buffer, 0, length);
    }
}