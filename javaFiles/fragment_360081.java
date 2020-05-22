void moveIfAtOrigin(double newX, double newY) { // upgrade
    // Could instead start with optimistic, not read mode
    long stamp = sl.readLock();
    try {
        while (x == 0.0 && y == 0.0) {
            long ws = sl.tryConvertToWriteLock(stamp);
            if (ws != 0L) {
                stamp = ws;
                x = newX;
                y = newY;
                break;
            }
            else {
                sl.unlockRead(stamp);
                stamp = sl.writeLock();
            }
        }
    } finally {
        sl.unlock(stamp);
    }
}