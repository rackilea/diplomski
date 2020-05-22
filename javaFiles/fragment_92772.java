val returnedObservable = observable<String> { subscriber ->
        subscriber.onNext("hello")
        subscriber.onCompleted()
    }
    .subscribeOn(Schedules.io())
    .observeOn(AndroidSchedulers.mainThread())