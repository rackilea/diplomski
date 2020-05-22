public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        Thread t1 = new Thread(new R1(monitor));
        Thread t2 = new Thread(new R2(monitor));

        t1.start();
        t2.start();

        t2.join();
        t1.join();
    }

    public static class R1 implements Runnable {

        private Object monitor;

        public R1(Object monitor) {
            this.monitor = monitor;
        }

        public void run() {
            System.out.println("R1 entered run");
            synchronized (monitor) {
                try {
                    monitor.wait();
                    System.out.println("R1 got monitor back");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static class R2 implements Runnable {

        private Object monitor;

        public R2(Object monitor) {
            this.monitor = monitor;
        }

        public void run() {
            System.out.println("R2 entered run");
            synchronized (monitor) {
                System.out.println("R2 will sleep for 1 sec");
                try {
                    Thread.sleep(1000);
                    System.out
                            .println("R2 will notify all threads waiting for monitor");
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}