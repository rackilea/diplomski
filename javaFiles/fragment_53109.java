// Mutex to share between the threads waiting for the result.
Object mutex = new Object();
...
onComplete() { 
    synchronized (mutex) {
        // It is done so we notify the waiting threads
        mutex.notifyAll();
    }
}

synchronized (mutex) {
    // Wait until being notified
    mutex.wait();
}