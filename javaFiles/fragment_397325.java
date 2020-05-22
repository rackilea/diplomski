final DataFetcher fetcher = new DataFetcher();
Callable<Data> task1 = new Callable<>() {
    @Override
    public Data call() {
        return fetcher.fetchData(1, 2);
     }
};
Callable<Data> task2 = new Callable<>() {
    @Override
    public Data call() {
        return fetcher.fetchData(3, 4);
     }
};

Future<Data> result1 = executorService.submit(task1);
Future<Data> result2 = executorService.submit(task2);