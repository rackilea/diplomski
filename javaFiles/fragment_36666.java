public class MyRunnable implements Runnable {
  private int decide;

  public MyRunnable(int decide) {
    this.decide = decide;
  }

  public void run() {
    ...
  }
}