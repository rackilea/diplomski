import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CriticalMonitor {
    public static int SOURCE_N = 0;
    public static AtomicInteger N = new AtomicInteger(SOURCE_N);
    public static ReentrantLock lock = new ReentrantLock(true);
    public static Condition condition = lock.newCondition();


    public void uncritical(int threadID) {
        System.out.println("Thread " + threadID + ": Uncritical!");
        N.getAndDecrement();
        if (N.get() == 0) {
            lock.lock();
            try {
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        }
    }

    public void critical(int threadID) {
        lock.lock();
        try {
            while (N.get() != 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    System.out.println("Critical failed");
                }
            }
            System.out.println("Thread " + threadID + ":Critical !");
            N.getAndDecrement();
        } finally {
            lock.unlock();
        }
    }
}