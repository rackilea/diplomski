Observable
 .just(1,2,3)
 .subscribeOn(Schedulers.io())
 .zipWith(Observable.interval(1000,1000,TimeUnit.milliseconds),
     (item, pos) -> item)
 .doOnCompleted(() -> System.out.println("Complete");
 .subscribe(item -> System.out.println(item));