lock.lock();
try {
    childThread.start();
    condition.await(5, TimeUnit.SECONDS);
} finally {
    sharedLock.lock();
}