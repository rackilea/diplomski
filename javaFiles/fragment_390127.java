Subject<Integer, Integer> source = PublishSubject.<Integer>create().toSerialized();

ConnectableObservable<Integer> co = source.sample(
    500, TimeUnit.MILLISECONDS, Schedulers.io())
.onBackpressureBuffer().publish();

co.subscribe(yourSubscriber);
co.connect();

source.onNext(1);