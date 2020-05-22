public void doWork(Runnable runnable) throws IOException, InterruptedException {

    while (IsRunning) {
        threadPool.submit(runnable);

        Thread.sleep(1000);
    }
}