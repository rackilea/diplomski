public static void readUtf8(URLConnection connection, Appendable out)
      throws IOException {
    CharBuffer buffer = CharBuffer.allocate(1024);
    try (InputStream in = connection.getInputStream();
    Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
      while (reader.read(buffer) != -1) {
        buffer.flip();
        out.append(buffer);
        buffer.clear();
      }
    }
  }