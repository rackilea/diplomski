if (readLock.tryLock(10, TimeUnit.SECONDS)) {
    try {

         [...]
    } finally {
         readLock.unlock();
    }
} else {
    // failed to get lock
}