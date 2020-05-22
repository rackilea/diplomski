public static void main(
    String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();
    executor.execute(new Runnable() {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

            } finally {
                System.out.println("Thread 2 is finished");
            }
        }
    });
    executor.shutdown();
    System.out.println("Thread 1 is finished");
}