Observable.interval(5, TimeUnit.SECONDS) 
    .flatMap(new Function<Long, ObservableSource<Boolean>>() {
                @Override
                public ObservableSource<Boolean> apply(Long aLong) throws Exception {
                    return observable;
                }
            })
    .subscribeOn(Schedulers.newThread())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe(mSolutionObserver);