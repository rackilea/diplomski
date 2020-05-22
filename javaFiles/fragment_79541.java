public class Multithreading extends Thread {
static int i = 0;

private static CountDownLatch LATCH;

public static void main(String args[]) throws InterruptedException {

    // Initialize the latch with the number of threads to finish
    LATCH = new CountDownLatch(2);

    call1();

    // Main thread will wait until all thread finished
    LATCH.await();

    call2();
}

private static void call2() {

    Multithreading call2obj1 = new Multithreading() {
        public void run() {
            System.out.println("call2obj1");
        }
    };
    call2obj1.start();

}

private static void call1() {

    Multithreading call1obj1 = new Multithreading() {
        public void run() {
            System.out.println("call1obj1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LATCH.countDown();
            }
        }
    };
    Multithreading call1obj2 = new Multithreading() {
        public void run() {
            System.out.println("call1obj2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LATCH.countDown();
            }
        }
    };
    call1obj1.start();
    call1obj2.start();

}