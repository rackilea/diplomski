// Object to be used as a lock; pass this to all Thread1 instances
Object lock = new Object();

// Somewhere else in your code
synchronized (lock) {
    lock.wait();
}

// Where you want to notify
synchronized (lock) {
    lock.notifyAll();
}