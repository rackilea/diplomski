import java.util.Random;

class Counter implements Runnable {
    private int a;

    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = Thread.currentThread().getName();
            a++;
            System.out.println(name + " Before sleep, a = " + a);
            try {
                // Add a little more uncertainty...
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                // Ignored
            }
            System.out.println(name + " After sleep, a = " + a);
        }
    }
}

public class ThreadingTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);
        t1.start();
        t2.start();
    }
}