new Thread() {
  public void run() {
    someThread.join(); // someThread is the thread that you're waiting to die
    // your block of code
  }
}.start();