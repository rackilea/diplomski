//We'll use Single. Unlike Observable it returns only one value and then completes.
public Single<SomethingResult> getSomethingResultFromDb(Object params) {
    //we will use zip() operator to combine query results
    return Single.zip(
            doFirstQuery(params),
            doSecondQuery(params),
            (firstQueryResult, secondQueryResult) -> {
                //combine results into new SomethingResult
                return Single.just(somethingResult);
            });
}

private Single<List> doFirstQuery(Object params) {
    return Single.fromCallable(() -> { //or Single.defer()
        //your first db query with params
        return firstQueryResult;
    });
}

private Single<Long> doSecondQuery(Object params) {
    return Single.fromCallable(() -> { //or Single.defer()
        //your second db query with params
        return secondQueryResult;
    });
}