class AutoUnlock implements AutoCloseable {
  private final Lock lock;

  public static AutoUnlock lock(Lock lock) {
    lock.lock();
    return new AutoUnlock(lock);
  }

  public static AutoUnlock tryLock(Lock lock) {
    if (!lock.tryLock()) {
       throw new LockNotAcquiredException();
    }
    return new AutoUnlock(lock);
  }

  @Override
  public void close() {
    lock.unlock();
  }

  private AutoUnlock(Lock lock) {
    this.lock = lock;
  }
}