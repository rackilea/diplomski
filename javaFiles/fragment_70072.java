try {
  lock.lockInterruptibly();
  try {
    // do locked work here
  } finally {
    lock.unlock();
  }
} catch( InterruptedException e ) {
  Thread.currentThread.interrupt();
}