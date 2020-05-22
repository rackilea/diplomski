final ExecutorService service = Executors.newCachedThreadPool();
    final List<Future<Double>> futures = service.invokeAll(tasks, 2, TimeUnit.SECONDS);
    final List<CallableTask> tasks = Arrays.asList(new CallableTask(1, TimeUnit.SECONDS),
            new CallableTask(1, TimeUnit.HOURS), new CallableTask(100, TimeUnit.MILLISECONDS),
            new CallableTask(50, TimeUnit.SECONDS));

    for (Future<Double> result : futures) {
        if (!result.isCancelled())  {
            try {
                System.out.println("Result: " + result.get());
            } catch (ExecutionException e) {
                // Task wasn't completed because of exception, may be required to handle this case
            }
        }
    }