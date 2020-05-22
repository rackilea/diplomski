public static synchronized void main(String[] args) throws InterruptedException {
  Thread t = new Thread() {
    public void run() {
      System.out.print("X");
      try { Thread.sleep(10000); } catch (InterruptedException e) { }
    }
  };

  t.start();
  t.join();

  System.out.print("Y");
}