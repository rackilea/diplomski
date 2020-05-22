Thread thread1 = new Thread(
  new Runnable() {
    @Override
    void run() {
      try {
        LOCK.lockInterruptibly();
        System.out.println("work");
        LOCK.unlock();
      } catch (InterruptedException ier) {
        Thread.currentThread().interrupt()
      }
    }
  }
);