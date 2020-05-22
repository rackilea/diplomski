import java.util.concurrent.atomic.AtomicInteger;

class Odd implements Runnable {

    private AtomicInteger integer;
    private final Object lock;

    public Odd(AtomicInteger integer, Object lock) {
        this.integer = integer;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                while (integer.get() <= 100) {
                    while (integer.get() % 2 == 0) {
                        lock.notify();
                        lock.wait();
                    }
                    if (integer.get() <= 100) {
                        System.out.println("Thread " +
                                Thread.currentThread().getName() + ": The number is '" + integer.get() + "'");
                    }
                    integer.getAndIncrement();
                    lock.notify();
                }
            } catch (Exception e) {

            }
        }
    }
}

class Even implements Runnable {

    private AtomicInteger integer;
    private final Object lock;

    public Even(AtomicInteger integer, Object lock) {
        this.integer = integer;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                while (integer.get() <= 100) {
                    while (integer.get() % 2 != 0) {
                        lock.notify();
                        lock.wait();
                    }
                    if (integer.get() <= 100) {
                        System.out.println("Thread " +
                                Thread.currentThread().getName() + ": The number is '" + integer.get() + "'");
                    }

                    integer.getAndIncrement();
                    lock.notify();
                }
            } catch (Exception e) {

            }
        }
    }
}

public class ThreadSynchronization {

    public static void main(String[] args) throws Exception{
        Object lock = new Object();
        AtomicInteger integer = new AtomicInteger(1);
        Odd odd = new Odd(integer, lock);
        Even even = new Even(integer, lock);

        Thread thread1 = new Thread(odd, "1");
        Thread thread2 = new Thread(even, "2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

}