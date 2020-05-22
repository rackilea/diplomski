public class Example implements Closeable {

  private boolean closed;

  public Example() {
    closed = false;
  }

  public void close() {
    if (!isClosed()) {
      closed = true;
    }
  }

  public boolean isClosed() {
    return closed;
  }
}