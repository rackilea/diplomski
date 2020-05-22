println("33")
    Completable.fromAction { println("75") }
            .delay(5, TimeUnit.SECONDS)
            .andThen(Completable.fromAction { println("82") })
            .delay(5, TimeUnit.SECONDS)
            .andThen(Completable.fromAction { println("93") })
            .delay(5, TimeUnit.SECONDS)
            .andThen(Completable.fromAction { println("101") })
            .subscribe()