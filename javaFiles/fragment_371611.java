Thread thread1 = new Thread() {
  @Override
  void run() {
    try {
      LOCK.lockInterruptibly();
      System.out.println("work");
      LOCK.unlock();
    } catch (InterruptedException ier) {
      this.interrupt()
    }
  }
};