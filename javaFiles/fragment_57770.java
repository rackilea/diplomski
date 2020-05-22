ExecutorService e = Executors.newFixedThreadPool(3);
    ExecutorService single = Executors.newSingleThreadExecutor();
    List<CompletableFuture<?>> futures = new ArrayList<>();
    futures.add(CompletableFuture.runAsync(new Worker(), e).thenRunAsync(this::someHook, single));
    futures.add(CompletableFuture.runAsync(new Worker(), e).thenRunAsync(this::someHook, single));
    futures.add(CompletableFuture.runAsync(new Worker(), e).thenRunAsync(this::someHook, single));

    futures.forEach(f -> f.get()); // try-catch left out for brevity