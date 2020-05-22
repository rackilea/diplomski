import java.lang.*;
import java.lang.Thread;
import java.lang.Runnable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

class Numprintt implements Runnable {
    private final CountDownLatch latch;
    private String myName;

    public Numprintt(String name, CountDownLatch latch) {
        this.myName = name;
        this.latch = latch;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i == 9 && latch != null) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.print(myName + i + " ");
        }
    }
}


public class MyRunnableTest {

    public static void main(String[] ar) {

        CountDownLatch latch = new CountDownLatch(1);

        Numprintt A = new Numprintt("A", null);
        Numprintt B = new Numprintt("B", latch);


        Thread t1 = new Thread(A);
        Thread t2 = new Thread(B);

        t1.start();
        t2.start();

        try {
            t1.join();
            latch.countDown();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}