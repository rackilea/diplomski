import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;


public class Single {
    private static String                       somefileContent = null;
    private static final ReentrantReadWriteLock readWriteLock   = new ReentrantReadWriteLock();
    private static final ReadLock               readLock        = readWriteLock.readLock();
    private static final WriteLock              writeLock       = readWriteLock.writeLock();

    public static String get() {
        try {
            readLock.lock();
            return somefileContent;
        } finally {
            readLock.unlock();
        }
    }

    public static void set(String str) {
        try {
            writeLock.lock();
            somefileContent = str;
        } finally {
            writeLock.unlock();
        }
    }
}