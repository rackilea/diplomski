public static class ZipEntryByteSource extends ByteSource {
  private final ByteSource source;
  private final String entryName;
  public ZipEntryByteSource(ByteSource zipSource, String entryName) {
    this.source = zipSource;
    this.entryName = entryName;
  }
  @Override public InputStream openStream() throws IOException {
    final ZipInputStream in = new ZipInputStream(source.openStream());
    while (true) {
      final ZipEntry entry = in.getNextEntry();
      if (entry == null) {
        in.close();
        throw new IOException("No entry named " + entry);
      } else if (entry.getName().equals(this.entryName)) {
        return new InputStream() {
          @Override
          public int read() throws IOException {
            return in.read();
          }

          @Override
          public void close() throws IOException {
            in.closeEntry();
            in.close();
          }
        };
      } else {
        in.closeEntry();
      }
    }
  }
}