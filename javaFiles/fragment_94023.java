class Fork {
    public static final char FORK = '|';
    public static final char NO_FORK = ' ';
    private int id;
    private Lock lock = new ReentrantLock();

    public Fork(final int id) {
        this.id = id;
    }

    public boolean isHeld() {
        return lock.isLocked();
    }

    // returns true if successfully grabbed!
    public synchronized boolean tryToGrab() {
        return lock.tryLock();
    }

    public void letGo() {
        lock.unlock();
    }
}