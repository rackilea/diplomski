final ExecutorService service = Executors.newWorkStealingPool();
for (final Object object : objectsToProcess) {
    service.submit(() -> {
            Go to database retrieve data.
            process
            save data
        }
    });
}