if (lock.tryLock(120, TimeUnit.SECONDS)) {
  try {
    // Do stuff.
  } finally {
    lock.unlock();
  }
}