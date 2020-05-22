public class MyRunnable implements Runnable {
  private int count = 0;
  public void run() {
    while (true) {
      System.out.println(count++);
    }
  }
}