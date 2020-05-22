private ReentrantLock lock = new ReentrantLock();
private Condition condition = lock.newCondition();
private boolean someFlag = false;
public void threadOneMethod() {
  lock.lock();
  try {
    someFlag = true;
    condition.signalAll();
  } finally {
    lock.unlock();
  }
}
public void threadTwoMethod() {
  lock.lock();
  try {
    while (someFlag == false) {
      condition.await();
    }

    System.out.println("Did some stuff");
    someFlag = false;
  } finally {
    lock.unlock();
  }
}