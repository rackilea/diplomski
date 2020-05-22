public synchronized void methodA() throws InterruptedException {
  new Thread() {
    public void run() {
      methodB();
    }
  }.start();
  Thread.sleep(10000);
}