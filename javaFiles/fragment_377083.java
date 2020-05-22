public Promise<V> await() throws InterruptedException {
if (isDone()) {
    return this;
}

if (Thread.interrupted()) {
    throw new InterruptedException(toString());
}

synchronized (this) {
    while (!isDone()) {
        checkDeadLock();
        incWaiters();
        try {
            wait();
        } finally {`enter code here`
            decWaiters();
        }
    }
}
return this;