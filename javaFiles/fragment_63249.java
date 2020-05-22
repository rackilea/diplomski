public class MyRunnable implements Runnable {
  private int count = 0;
  public void run() {
    while (!Thread.currentThread().isInterrupted()) {
      System.out.println(count++);
      try {
        Thread.sleep(0, 1);
      } catch (InterruptedException x) {
        return;
      }
    }
  }
}