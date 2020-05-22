Observable.interval(100, TimeUnit.MILLISECONDS)
    .doOnNext { println("emitting $it") }
    .toFlowable(BackpressureStrategy.LATEST)
    .observeOn(Schedulers.io(), false,1)
    .subscribeOn(Schedulers.io())
    .subscribe {
        println("consuming $it")
        Thread.sleep(500)
    }