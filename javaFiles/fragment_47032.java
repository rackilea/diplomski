Observable<Long> intervalObservable = Observable.interval(10, TimeUnit.SECONDS);

RxView.clicks(refreshButton)
    .switchMap(ignored -> {
        return intervalObservable
            .startWith(0L)                 // For an immediate refresh
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext(x -> performRefresh());
    })      
    .subscribe();