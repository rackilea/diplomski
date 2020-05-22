public void add() {
    lock.readLock().lock();
    //code.....

    lock.writeLock().lock();
    //code
    lock.writeLock().unlock();

    //code....
    l.readLock().unlock();
}