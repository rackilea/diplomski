public class  A {
    private LockDispenser dispenser;

    public A(LockDispenser dispenser) {
        this.dispenser = dispenser;
    }

    private void insert(String userId) {
        synchronized (dispenser.createLock(userId)) {
            // code
        }
        dispenser.releaseLock(userId); // consider putting this in a finally block
    }
}