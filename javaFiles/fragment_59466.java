Lock lock = ...;
if (lock.tryLock()) {
  try {
     // manipulate protected state
  } finally {
    lock.unlock();
  }
} else {
  // perform alternative actions
}