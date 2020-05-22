public void drain(InputStream in, OutputStream out) throws IOException {
    byte[] buffer = new byte[1024];
    int r;
    while ((r = in.read(buffer)) > -1) {
      out.write(buffer, 0, r);
    }
  }