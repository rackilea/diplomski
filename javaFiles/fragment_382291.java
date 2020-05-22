getObservable()
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.single())
        .blockingSubscribe {
            println(it)
        }