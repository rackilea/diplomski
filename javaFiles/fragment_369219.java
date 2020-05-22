public static class Response {
    int index;
    double result;
}

private static class MyTask implements Callable<Response> {
    private long from;
    private long to;

    public MyTask(long fromIndexInclusive, long toIndexExclusive) {
        this.from = fromIndexInclusive;
        this.to = toIndexExclusive;
    }

    public Response call() {
        int topResultIndex;
        double topResult = 0;

        for (long i = from; i < to; ++i) {
            double result = calculateResult(i);
            if (result > topResult) {
                topResult = result;
                topResultIndex = i;
            }
        }

        Response res = new Response();
        res.index = topResultIndex;
        res.result = topResult;
        return res;
    }
};

private static calculateResult(long index) { ... }

public Response interfaceMethod() {
    //You might want to make this static/shared/global
    ExecutorService svc = Executors.newCachedThreadPool();

    int chunks = Runtime.getRuntime().availableProcessors();
    long iterations = 1000000000;
    MyTask[] tasks = new MyTask[chunks];
    for (int i = 0; i < chunks; ++i) {
        //You'd better cast to double and round here
        tasks[i] = new MyTask(iterations / chunks * i, iterations / chunks * (i + 1));
    }

    List<Future<Response>> resp = svc.invokeAll(Arrays.asList(tasks));
    Iterator<Future<Response>> respIt = resp.iterator();

    //You'll have to handle exceptions here
    Response bestResponse = respIt.next().get();

    while (respIt.hasNext()) {
        Response r = respIt.next().get();
        if (r.result > bestResponse.result) {
            bestResponse = r;
        }
    }

    return bestResponse;
}