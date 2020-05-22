public static void main(String[] args) {
    final SharedData<Double> sharedData = new SharedData<Double>(5.7);
    final List<Callable<Void>> myCallables = new LinkedList<Callable<Void>>();

    for (int i = 0; i < 4; ++i) {
        myCallables.add(new MyReader("reader" + i, sharedData));
    }
    for (int i = 0; i < 2; ++i) {
        myCallables.add(new MyWriter("writer" + i, sharedData));
    }

    final ExecutorService executorService = Executors.newFixedThreadPool(myCallables.size());
    final List<Future<Void>> futures;
    try {
        futures = executorService.invokeAll(myCallables);
    } catch (InterruptedException ex) {
        throw new RuntimeException(ex);
    }
    for (final Future<Void> future : futures) {
        try {
            future.get();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        } catch (ExecutionException ex) {
            throw new RuntimeException(ex);
        }
    }
}