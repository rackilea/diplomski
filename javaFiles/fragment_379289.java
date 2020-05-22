public void parallelExecution(List<Integer> calls) {

    logger.debug("Starting parallel executions");

    // Create an iterable observables
    List<Observable<Integer>> observables = calls.stream()
            .map(i -> {
                return Observable.fromCallable(() -> simpleAsync(i))
                        .subscribeOn(Schedulers.newThread());
            })
            .collect(Collectors.toList());


    Observable.zip(observables, objects -> { // Zip observables
                return Arrays.stream(objects)
                        .map(Object::toString)
                        .collect(Collectors.toList());
            })
            .doOnNext(results -> logger.debug("Ending parallel executions"))
            .subscribe(results -> { // Subscribe to the result.
                // Put your code that needs to "wait"
                for (String x : results) {
                    logger.debug("Results: {}", x);
                }
            });
}