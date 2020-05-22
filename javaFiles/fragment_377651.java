Future<Result> future = executorService.submit(new Callable<>() {
    @Override
    Result call() {
        return performSynchronousWebServiceCall(...);
    }
});
doSomethingElseForAWhile(...);
Result result = future.get();