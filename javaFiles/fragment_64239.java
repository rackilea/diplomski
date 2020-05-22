ReentrantLock lock = ...;


public void run(){
    if (bar) {
        lock.lock();
    }

    try {
        // do something

    } finally {
        if (lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }
}