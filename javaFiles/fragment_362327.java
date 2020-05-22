class SynchTest {
    public static void main(String[] args) {
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
    }

    static class Task implements Runnable {
        long start;

        Task() {
            this.start = System.currentTimeMillis();
        }

        static final Object STATIC_MONITOR = new Object();

        @Override
        public void run() {
            synchronized (STATIC_MONITOR) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                System.out.println(System.currentTimeMillis() - start);
            }
        }
    }
}