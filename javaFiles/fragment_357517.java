// so we can be sure service1 and service2 are active
    val bothSubscribed = CountDownLatch(2)
    // so we can simulate a blocking, long running operation on both services
    val subscribeThreadsStillRunning = CountDownLatch(1)

    val service5 = { str: String, str2: String ->
        Observable.just("service5: $str, $str2").singleOrError()
    }

    val scheduler = Schedulers.io()

    val createSingle = { value: String ->
        Observable
            .create<String> { emitter ->
                println("subscribe $value on ${Thread.currentThread().name}")
                bothSubscribed.countDown()
                subscribeThreadsStillRunning.await(10, SECONDS)
                emitter.onNext(value)
            }
            .singleOrError()
            .subscribeOn(scheduler)
    }

    val s1 = createSingle("outer")
    val s4 = createSingle("inner")

    s1.flatMap { outer ->
        s4.flatMap { inner ->
            service5(outer, inner)
        }
    }.subscribe()

    assert(bothSubscribed.await(5, SECONDS))
    subscribeThreadsStillRunning.countDown()