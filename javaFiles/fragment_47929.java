public Object getObject() {
  lock.lock();
  try {
    int localstate = this.state;

    while (check && localstate == this.state)) {
      condition.await(); // all threads that are waiting here have the same state
    }

    if (!check) {
      this.state++; // first thread will change state thus making other threads ignore the 'check' value
    }

    return returnObjectAndSetCheckToFalse();
  } finally {
    lock.unlock();
  }
}