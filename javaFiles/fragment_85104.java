private final Object lock = new Object();
   private volatile Integer rowCount = null;
   ...

      public void run() {
         rowCount = data.size();
         synchronized (lock) {
            lock.notify();
         }
      }

  synchronized (lock) {
     // we loop here in case of race conditions or spurious interrupts
     while (rowCount == null) {
        lock.wait();
     }
  }
  ...