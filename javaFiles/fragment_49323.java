public static synchronized void main(String[] args) {
  Thread t = new Thread() {
    public void run() {
      System.out.print("X");
      try { Thread.sleep(10000); } catch (InterruptedException e) { }
      System.out.print("Y");
    }
  };

  t.start();
}