ExecutorService pool = Executors.newFixedThreadPool(20);
List<Future<String>> futures = new ArrayList<>();
futures.add(pool.submit(makeCallable("1.")));
// ...
for (Future<String> future : futures) {
    try {
        System.out.println(future.get());
    } catch (...) {
        ...
    }
}

public static Callable<String> makeCallable(String x) {
    Callable<String> c = ...;
    return c;
}