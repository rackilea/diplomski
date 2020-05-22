final ExecutorService executor = Executors.newFixedThreadPool(5); // it's just an arbitrary number
    final List<Future<?>> futures = new ArrayList<>();
    for (SellerNames sellerNames : sellerDataList) {
        for (final String sellerName : sellerNames) {
            Future<?> future = executor.submit(() -> {
                getSellerAddress(sellerName);
            });
            futures.add(future);
        }
    }
    try {
        for (Future<?> future : futures) {
            future.get(); // do anything you need, e.g. isDone(), ...
        }
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }