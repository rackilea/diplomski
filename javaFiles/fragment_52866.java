public E take() throws InterruptedException {
    E x;
    int c = -1;
    final AtomicInteger count = this.count;
    final ReentrantLock takeLock = this.takeLock;
    takeLock.lockInterruptibly();
    ...
}

// declared as
private final ReentrantLock takeLock = new ReentrantLock(); // no fairness argument, defaults to false