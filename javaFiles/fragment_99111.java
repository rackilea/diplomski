Disposable disposable = Maybe.just("aaa")
    .delay(2000, TimeUnit.MILLISECONDS)
    .doOnDispose({ /* do something */ })
    .subscribe( ... )

disposable.dispose();