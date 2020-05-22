class A {

  private final ReentrantLock lock = new ReentrantLock();
  private Condition someCondition = lock.newCondition();
  private boolean bCondition = false;

  getResource{ ... } // Your existing method used by B threads

  getAccess() { // Protected access to some resource, called by C thread
    lock.acquire();

    try {
      if (!bCondition)
        someCondition.await(); // B thread will wait here but releases the lock
    } finally {
      lock.release();
    }
  }

  allowAccess() { // B thread can call this func to notify C and allow access
    lock.acquire();
    try {
      bCondition = true;
      someCondition.signal(); // Decided to release the resource
    } finally {
      lock.release();
    }
  }

  stopAccess() { // B thread can stop the access
    lock.acquire();
    try {
      bCondition = false;
    } finally {
      lock.release();
    }
  }

}