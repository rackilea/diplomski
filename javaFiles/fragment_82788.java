public class ThreadInterference {
  public static final Object COUNT_LOCK = new Object();
  public static int count = 1000; // Either "int" or "Integer" OK, depending on need

  public static class MyThread implements Runnable {
    @Override
    public void run() {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      for (int i = 0; i < 10000; i++) {
        synchronized(COUNT_LOCK) {
          count++;
          count--;
          count++;
          count--;
        }
      }
    }
  }

  // And so on...
}