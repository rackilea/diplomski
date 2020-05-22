MySystem system = ... /* Set up whatever you need as a context. */
ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
worker.schedule(system::someAction1, t1, TimeUnit.MILLIS);
worker.schedule(system::someAction2, t2, TimeUnit.MILLIS);
...
worker.shutdown();