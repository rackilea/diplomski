class SynchTest {
    public static void main(String[] args) {
        // Note that we create a new Task each time.
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
    }

    static class Task implements Runnable {
        long start;

        Task() {
            this.start = System.currentTimeMillis();
        }

        @Override
        public synchronized void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println(System.currentTimeMillis() - start);
        }
    }
}