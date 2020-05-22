public boolean handShake() {
    Runnable handShakeTask = new Runnable() {
        @Override
        public void run() {
            // do network stuff
        }
    };
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    try {
        Future<Boolean> future = executorService.submit(networkTask, true);
        executorService.shutdown();
        return future.get(8, TimeUnit.SECONDS);
    } catch (TimeoutException ex) {
        return false;
    } catch (InterruptedException | ExecutionException e) {
        // handle exception
    } 
}