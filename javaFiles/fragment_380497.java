public class MyQueue<T> {

  private Semaphore semaphore;

  public void put(Work<T> w) {
    w.setQueue(this);
  }

  public Work<T> tryPoll() {
    return null;
  }


  public abstract static class Work<T> implements Callable<T> {

    private MyQueue<T> queue;

    private void setQueue(MyQueue<T> queue) {
      if(queue != null) {
        throw new IllegalStateException("Cannot add a Work object to multiple Queues!");
      }
      this.queue = queue;
    }

    @Override
    public final T call() throws Exception {
      try {
        return callImpl();
      } finally {
        queue.semaphore.release();
      }
    }

    protected abstract T callImpl() throws Exception;
  }
}