import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class H2OProducer {
    static final int H2O_COUNT = 1_000;
    static final Random rand = new Random();

    static final Lock lock = new ReentrantLock(true);
    static final Condition oxzWait = lock.newCondition();
    static final Condition hydWait = lock.newCondition();

    static volatile int hydCount = 0;

    public static void main(String[] args) {
        try {
            Thread h1 = new Thread(() -> {
                try {
                    hydrogenProducer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread h2 = new Thread(() -> {
                try {
                    hydrogenProducer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread o = new Thread(() -> {
                try {
                    oxygenProducer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            h1.setName("H1-Producer");
            h2.setName("H2-Producer");
            o.setName("Ox-Producer");

            h1.start();
            h2.start();
            o.start();

            try {
                h1.join();
                h2.join();
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }

    }

    public static void hydrogenProducer() throws InterruptedException {
        for (int i = 0; i < H2O_COUNT; i++) {
            lock.lock();
            try {
                while (hydCount == 2) {
                    hydWait.await();
                }

                hydCount++;
                System.out.println(Thread.currentThread().getName()+ ": H produced - " + i);

                if (hydCount == 2) {
                    oxzWait.signalAll();
                }
            } finally {
                lock.unlock();
            }

            randomSleep();
        }
    }

    public static void oxygenProducer() throws InterruptedException {
        for (int i = 0; i < H2O_COUNT; i++) {
            lock.lock();
            try {
                while (hydCount < 2) {
                    oxzWait.await();
                }

            hydCount = 0;
            System.out.println(Thread.currentThread().getName()+ ": O produced - " + i);
            System.out.println("");
            hydWait.signalAll();
            } finally {
                lock.unlock();
            }

            randomSleep();
        }
    } 

    public static void randomSleep() {
        int ms = rand.nextInt(500);
        try { 
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }
}