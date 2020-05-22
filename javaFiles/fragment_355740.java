List<Future<Void>> futures = new ArrayList<>();
for (int i = 1; i <= 5; i++) {
    Future<Void> future = taskExecutor.submit(new MyCallable());
    futures.add(future);
}

// After all tasks have started, now wait for all of them to complete (they run in parallel)
// and check if there were any exceptions

for (Future<Void> future : futures) {
    try {
        future.get();
    } catch (ExecutionException e) {
        // Access the exception thrown by the different thread.
        e.getCause().printStackTrace();
    }
}