class Worker implements Callable<String> {
    private final List<String> pathnames;
    private final AtomicInteger index = new AtomicInteger();
    public Worker(List<String> pathnames) {
        this.pathnames = pathnames;
    }
    public String call() {
        String pathname = list.get(index.getAndIncrement());
        ...
        return ...;
    }
}

// caller
Worker worker = new Worker(pathnames);
List<Future<String>> futures = new ArrayList<>();
for (String pathname : pathnames) {
    futures.add(pool.submit(worker));
}