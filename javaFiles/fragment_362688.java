ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
List<Future<String>> results = executor.invokeAll(Arrays.asList(new Task()), 1, TimeUnit.SECONDS); // Timeout of 1 second.
for (Future<String> result : results) {
    if (!result.isCancelled()) {
        System.out.println(result.get()); // Won't be printed as the "actual" processing took 2 seconds.
    } else {
        System.out.println("Task timed out.");
    }
}
executor.shutdown();