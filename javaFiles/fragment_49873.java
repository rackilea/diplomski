private static List<Double> concurrently(Collection<Callable<Double>> callables) throws InterruptedException, ExecutionException {
    ExecutorService executors = Executors.newCachedThreadPool();
    Collection<Future<Double>> futures = executors.invokeAll(callables);
    List<Double> res = new ArrayList<>();
    for (Future<Double> future: futures) {
        res.add(future.get());
    }
    executors.shutdownNow();
    return res;
}