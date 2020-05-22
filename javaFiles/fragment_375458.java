public static void writeTo(InputStream in, OutputStream out) throws IOException {
    int read;
    final byte[] data = new byte[BUFFER_SIZE];
    while ((read = in.read(data)) != -1) {
        out.write(data, 0, read);
    }
}