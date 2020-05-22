void write(InputStream is, OutputStream os) throws IOException {
    byte[] buf = new byte[512]; // optimize the size of buffer to your need
    int num;
    while ((num = is.read(buf)) != -1) {
      os.write(buf, 0, num);
    }
}