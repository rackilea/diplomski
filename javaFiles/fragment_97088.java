import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DeviceHandler
{
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private BlockingQueue<Object> readersQueue = new ArrayBlockingQueue<>(10);

    public void read() throws InterruptedException
    {
        // if queue is full, this blocks until another thread removes an object
        readersQueue.put(new Object());
        // this blocks if another thread acquires the write lock
        reentrantReadWriteLock.readLock().lock();

        // do read action

        reentrantReadWriteLock.readLock().unlock();
        readersQueue.take();
    }

    public void write()
    {
        // this blocks if the read lock is acquired by other threads
        reentrantReadWriteLock.writeLock().lock();

        // do write action

        reentrantReadWriteLock.writeLock().unlock();
    }
}