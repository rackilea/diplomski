Observable<String> AObservable = Observable.fromCallable(() -> {
    Thread.sleep(100);
    return "response A";
}).timeout(800, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .onErrorResumeNext((value) -> {
            return Observable.empty();
        });

Observable<String> BObservable = Observable.fromCallable(() -> {
    Thread.sleep(1500);
    return "response B";
}).timeout(800, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.io())
        .onErrorResumeNext((value) -> {
            return Observable.empty();
        });

Observable<String> CObservable = Observable.fromCallable(() -> "default response")
        .subscribeOn(Schedulers.io());

String result = Observable.zip(AObservable, BObservable,
        (AResponse, BResponse) -> AResponse + " and " + BResponse)
        .switchIfEmpty(CObservable)
        .singleElement()
        .blockingGet();

System.out.println(result);