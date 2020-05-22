public void method() {
    lock.lock();
    try {
        // rest of the method
    } finally {
        lock.unlock();
    }
}