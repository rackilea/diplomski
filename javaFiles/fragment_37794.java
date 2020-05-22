ExecutorService es = Executors.newFixedThreadPool(2);

es.invokeAny(Arrays.asList(
    () -> { worker.run(); return null; },
    () -> System.in.read() ));

es.shutdown();
System.exit(0);