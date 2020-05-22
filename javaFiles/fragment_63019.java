public byte[] toByteArray(InputStream is) throws IOException {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    int l;
    byte[] data = new byte[1024];
    while ((l = is.read(data, 0, data.length)) != -1) {
      buffer.write(data, 0, l);
    }
    buffer.flush();
    return buffer.toByteArray();
}