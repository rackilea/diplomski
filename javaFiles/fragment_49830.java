public class WaitableCallback implements Callback {

  private boolean done;
  private IOException exception;

  private final Object[] signal = new Object[0];

  @Override
  public void onResponse(Call call, Response response) throws IOException {
      ...
      synchronized (this.signal) {
        done = true;
        signal.notifyAll();
      }
  }

  @Override
  public void onFailure(Call call, IOException e) {
    synchronized (signal) {
      done = true;
      exception = e;
      signal.notifyAll();
    }
  }

  public void waitUntilDone() throws InterruptedException {
    synchronized (this.signal) {
      while (!this.done) {
        this.signal.wait();
      }
    }
  }

  public boolean isDone() {
    synchronized (this.signal) {
      return this.done;
    }
  }

  public IOException getException() {
    synchronized (this.signal) {
      return exception;
    }
  }

}