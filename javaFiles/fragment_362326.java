class SynchTest {
    public static void main(String[] args) {
        // Now we pass the same instance each time.
        Task t = new Task();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
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