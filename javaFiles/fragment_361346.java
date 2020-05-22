private static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();

private static <T> T timedCall(FutureTask<T> task, long timeout, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    THREAD_POOL.execute(task);
    return task.get(timeout, timeUnit);
}


public static void main(String[] args) {
        try {
            FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
                public Integer call() throws Exception {
                        for (int i=0; i < 1000000; i++) {
                                if (Thread.interrupted()) return 1;
                                System.out.println(new java.util.Date());
                                Thread.sleep(1000);
                        }
                        return 0;
                }
            });
            int returnCode = timedCall(task, 100, TimeUnit.SECONDS);
        } catch (Exception e) {
                e.printStackTrace();
                task.cancel(true);
        }
        return;
}