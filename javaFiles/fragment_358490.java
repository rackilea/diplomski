public class Chopstick {
  private final Lock lock = new ReentrantLock();
  private final Condition chopstickFree = lock.newCondition();
  private volatile boolean isFree = true;

  Chopstick() { /* Nothing */ }

  // Pick up chopstick
  public void pickUpChopstick() throws InterruptedException {
    lock.lock();

    try {
      while (!isFree) {
        chopstickFree.await();
      }
      isFree = false;
    } finally {
      lock.unlock();
    }
  }

  // Release chopstick
  public void releaseChopstick() {
    lock.lock();
    try {
      isFree = true;
      chopstickFree.signal();
    } finally {
      lock.unlock();
    }
  }
}