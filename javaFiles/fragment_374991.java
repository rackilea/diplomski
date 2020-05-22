class myRunner implements Runnable {
  public void run() {
    while (true) {
      String ln = in.nextLine();
      out.println(ln);
    }
  }
}
new Thread(new myRunner()).start();