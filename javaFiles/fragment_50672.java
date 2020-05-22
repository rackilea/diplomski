public void populateData() {

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Callable<String> calls = new Callable<String>() {

        @Override
        public String call() throws Exception {
            for (;;){
                Thread.sleep(100);
                // You call interrupt here, which causes Future.get() interrupt
                Thread.currentThread().interrupt();
                if (1 > 2) break;
            }
            return null;
        }
    };
    final Future<String> future = executorService.submit(calls);

    waitForTaskCompletion(future);
    executorService.shutdown();
}