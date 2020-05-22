public class ThreadInterference {
  public static AtomicInteger count = new AtomicInteger(1000);

  public static class MyThread implements Runnable {
    @Override
    public void run() {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      for (int i = 0; i < 10000; i++) {
        count.incrementAndGet();
        count.decrementAndGet();
        count.incrementAndGet();
        count.decrementAndGet();
      }
    }
  }

  // And so on...
}