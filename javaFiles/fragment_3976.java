public abstract class Worker implements Runnable {
  private final Object lock = new Object();
  private final AtomicBoolean shouldWait = new AtomicBoolean();

  protected abstract boolean processingIsComplete();
  protected abstract void process();
  protected abstract void cleanUpResources();

  public Object getLock() {
    return lock;
  }

  public void disable() {
    shouldWait.set(false);
  }

  public void enable() {
    shouldWait.set(true);
  }

  @Override
  public void run() {
    try {
      while(!processingIsComplete()) {
        while(!shouldWait.get()) {
          synchronized(lock);
            lock.wait();
          }
        }
        process();
      }
    } catch(InterruptedException e) {
      System.out.println("Worker thread stopped");
    } finally {
      cleanUpResources();
    }
  }
}