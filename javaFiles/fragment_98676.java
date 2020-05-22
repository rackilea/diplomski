/**
 * Bounded implementation of {@link DelayQueue}. This implementation uses
 * reflection to access the internal lock in {@link DelayQueue} so might
 * only work on the Oracle 1.8 JRE.
 * @param <T>
 */
public class BoundedDelayQueue<T extends Delayed> extends DelayQueue<T> {

    // Lock used to synchronize every operation
    private final transient ReentrantLock lock;

    // The limit
    private final int limit;

    BoundedDelayQueue(int limit) {
        try {
            // Grab the private lock in DelayQueue using reflection so we can use it
            // to gain exclusive access outside of DelayQueue
            Field lockField = DelayQueue.class.getDeclaredField("lock");
            lockField.setAccessible(true);
            this.lock = (ReentrantLock) lockField.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error("Could not access lock field", e);
        }
        this.limit = limit;
    }

    @Override
    // All the various ways of adding items in DelayQueue delegate to
    // offer, so we only have to override it and not the other methods
    public boolean offer(final T t) {
        // Lock the lock
        lock.lock();
        try {
            // Check the size limit
            if(size() == limit) {
                return false;
            }
            // Forward to superclass
            return super.offer(t);
        } finally {
            lock.unlock();
        }
    }
}