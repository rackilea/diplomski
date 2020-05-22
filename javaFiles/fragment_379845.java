while (!VolatileTest.lock.compareAndSet(false, true) { } // or while (VolatileTest.lock.getAndSet(true)) {} - try to get lock
try {
    // code to execute under lock
} finally {
    VolatileTest.lock.set(false); // unlock
}