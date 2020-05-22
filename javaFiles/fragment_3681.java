private boolean condition = ...
  private Object lock = new Object();  // mutex for 'condition'

  ...

  synchronize (lock) {
      while (!condition) {
           wait(lock);
           // It is UNSAFE to assume that 'condition' is true now.
      }
  }