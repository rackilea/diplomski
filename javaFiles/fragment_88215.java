A a = new A();
ReentrantLock lock = new ReentrantLock();
...
// in each run() 
if (lock.tryLock()) {
    try {
        a.setX(); // might require further synchronization
    } finally {
        lock.unlock();
    }
} else {
    a.setY(); // might require further synchronization 
}