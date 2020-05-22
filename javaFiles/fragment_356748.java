final ReentrantLock lock = new ReentrantLock();

public void write(...){
  try {
    lock.lock()
    // do the writing
  } finally {
    // forget this and you're screwed
    lock.unlock();
  }
}