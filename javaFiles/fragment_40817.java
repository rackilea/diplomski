public class GzippedByteSource extends ByteSource {
  private final ByteSource source;
  public GzippedByteSource(ByteSource gzippedSource) { source = gzippedSource; }
  @Override public InputStream openStream() throws IOException {
    return new GzipInputStream(source.openStream());
  }
}