public class LockDispenser {
    private final Map<String, Lock> dispenser = new LinkedHashMap<>();

    public Object createLock(String forId) {
        synchronized (dispenser) {
            if (!dispenser.containsKey(forId)) {
                dispenser.put(forId, new Lock());
            }
            Lock lock = dispenser.get(forId);
            lock.referenceCounter++;
            return lock;
        }
    }

    public void releaseLock(String forId) {
        synchronized (dispenser) {
            Lock lock = dispenser.get(forId);
            lock.referenceCounter--;
            if (lock.referenceCounter == 0) {
                dispenser.remove(forId);
            }
        }
    }

    public static class Lock {
        private int referenceCounter = 0;
    }
}