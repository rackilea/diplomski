class MyReentrantReadWriteLock {
    private int state; // 0 - free, -1 - write locked, n>0 - read locked n times
    public bool tryLock(LockMode lockMode) {
        switch(lockMode) {
        case READ:
            if(state == -1) return false; // Already write-locked.
            state++;
            return true;
        case WRITE:
            if(state) return false; // Already locked.
            state = -1;
            return true;
        }
    public void unlock() {
         switch(state) {
         case 0:
             // error: not locked
         case -1:
             state = 0; // write unlock
             break;
         default:
             state--; // read unlock
         }
    }
    public bool isLocked() {
        return state != 0;
    }
};