public class Marathon2 {

    public static void main(String[] args)
            throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService service = null;

        Runnable task = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()
                            + " is running... " + i);
                    TimeUnit.MILLISECONDS.sleep(200);
                }

            } catch (InterruptedException e) {
            }
        };
        try {
            service = Executors.newFixedThreadPool(4);

            Future<?> job1 = service.submit(task);
            TimeUnit.MILLISECONDS.sleep(100);
            Future<?> job2 = service.submit(task);
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}