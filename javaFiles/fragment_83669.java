public class B {
    private LockDispenser dispenser;

    public B(LockDispenser dispenser) {
        this.dispenser = dispenser;
    }

    private void refresh(String userId) {
        synchronized (dispenser.createLock(userId)) {
            // code
        }
        dispenser.releaseLock(userId); // consider putting this in a finally block
    }
}