main () {
    ArrayList<Future<?>> futures = new ArrayList<Future<?>>();
    ExecutorService exec = Executors.newFixedThreadPool(Runtime.getNumProcessors())
    futures.add(exec.submit(Test1));
    ...
    futures.add(exec.submit(Testn));

    for (Future<?> future:futures) {
       ? result = future.get();
    }
}