import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        final Lock l = new ReentrantLock();

        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+": Acquire lock");
                l.lock();
                System.out.println(Thread.currentThread()+": Lock aquired: wait");
                LockSupport.parkNanos(1_000_000_000);
                System.out.println(Thread.currentThread()+"; Exiting");
            }
        };
        t.start();
        LockSupport.parkNanos(500_000_000);
        System.out.println(Thread.currentThread()+": Acquire lock");
        l.lock();
        System.out.println(Thread.currentThread()+"; Success!");
    }
}