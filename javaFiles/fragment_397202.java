observable = Observable.create(emitter -> {
        try {
            Data next = getDataFromDb();
            emitter.onNext(next);
        } catch (SQLiteException e) {
            emitter.onError(e);
        }
    }, Emitter.BackpressureMode.BUFFER)
    .toList()
    .compose(applySchedulers())
    .replay(1)
    .autoConnect()
//start your prefetch
observable.subscribe()//you should better add some log to see the process

//In your Activity
observable.subscribe(/**Your Subscribe**/)// here you will get the replayed value