class Query implements Callable<String> {
    public String call() {
        String s = ""; // do some database query that returns a string
        return s;
    }
}

public static void main(String[] args) {
    var queries = List.of(new Query(...), ...);
    var exec = Executors.newFixedThreadPool(queries.size());
    var futures = exec.invokeAll(queries);

    for (f : futures) {
        f.get();
    }
}