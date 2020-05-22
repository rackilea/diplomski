class NewThreadt extends Thread {

  private static Object lock = new Object();

  void dota(int a) {
    System.out.println(a);
  }

  // This is the entry point for the second thread.
  public void run() {
    synchronized (lock) {
      try {
        for (int i = 5; i > 0; i--) {

          dota(i);
          Thread.sleep(500);
        }
      } catch (InterruptedException e) {
        System.out.println("Child interrupted.");
      }
      System.out.println("Exiting child thread.");
      System.out.println(Thread.currentThread());
    }
  }
}