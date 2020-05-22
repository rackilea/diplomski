Observable<Long> intervalObservable = Observable.interval(10, TimeUnit.SECONDS)
    .startWith(0L)  // For an immediate refresh
    .observeOn(AndroidSchedulers.mainThread())
    .doOnNext(x -> performRefresh());

Observable<Long> buttonClickedObservable = RxView.clicks(refreshButton)
    .map(e -> 0L)  // To make the compiler happy
    .switchMap(ignored -> Observable.error(new RuntimeException("button pressed")));

Observable.merge(intervalObservable, buttonClickedObservable)
    .retry()
    .subscribe();