methodA()
    .subscribeOn(Schedulers.io())
    .flatMapObservable(Observable::from)
    .flatMap(this::methodB)
    .observeOn(AndroidSchedulers.mainThread())
    .takeWhile(id -> id <= 0)
    .subscribe(...);