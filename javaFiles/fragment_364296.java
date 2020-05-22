ExecutorService executorService = Executors.newFixedThreadPool(16);
List<Future<Result>> futures = ..;
 for (int j = 1; j < 900+ 1; j++) {
 int start = (j - 1) * 5000;
 int stop = (j) * 5000- 1;
 FetcherRunner runner = new FetcherRunner(routes, start, stop);
 futures.add(executorService.submit(runner));

}
for (Future<Result> future:futures){
    future.get(); //Do something with the results..
}