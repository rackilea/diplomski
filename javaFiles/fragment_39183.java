public final class CheckedInputStream extends InputStream {
  final InputStream delegate;
  boolean validated;

  public CheckedInputStream(InputStream stream) throws FileNotFoundException {
    delegate = stream;
    validated = true;
  }

  public void invalidate() {
    validated = false;
  }

  void checkValidated() {
    if (!validated) {
      throw new IllegalStateException("Stream is invalidated.");
    }
  }

  @Override
  public int read() throws IOException {
    checkValidated();
    return delegate.read();
  }

  @Override
  public int read(byte b[]) throws IOException {
    checkValidated();
    return read(b, 0, b.length);
  }

  @Override
  public int read(byte b[], int off, int len) throws IOException {
    checkValidated();
    return delegate.read(b, off, len);
  }

  @Override
  public long skip(long n) throws IOException {
    checkValidated();
    return delegate.skip(n);
  }

  @Override
  public int available() throws IOException {
    checkValidated();
    return delegate.available();
  }

  @Override
  public void close() throws IOException {
    checkValidated();
    delegate.close();
  }

  @Override
  public synchronized void mark(int readlimit) {
    checkValidated();
    delegate.mark(readlimit);
  }

  @Override
  public synchronized void reset() throws IOException {
    checkValidated();
    delegate.reset();
  }

  @Override
  public boolean markSupported() {
    checkValidated();
    return delegate.markSupported();
  }
}