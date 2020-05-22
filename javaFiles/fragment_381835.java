public class MyDataReader {

  private final TarArchiveInputStream tar;

  public boolean hasNextData() {
    return tar.getNextTarEntry() != null;
  }

  public MyData nextData() {
    byte[] buff = new byte[tar.getCurrentEntry().getSize()];
    // loop over tar until all entry has been read
    InputStream entry = new ByteArrayInputStream(buff);
    GZIPInputStream gzip = new GZipInputStream(entry);
    // process gzip input stream
  }
}