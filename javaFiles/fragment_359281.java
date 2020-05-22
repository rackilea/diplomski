Observable.interval(300, TimeUnit.MILLISECONDS)
.flatMap(t -> Observable.fromCallable(() -> { 
        Thread.sleep(1000);
     }).subscribeOn(Schedulers.io()))
.map(...)
.takeWhile(...)
.subscribe(...)