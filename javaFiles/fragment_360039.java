private final ReentrantLock lock = new ReentrantLock();

.....

public void foo() { 
  lock.lock();
  try {
    // do whatever modification you want
  } finally {
    lock.unlock();
  }
}