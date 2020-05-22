Observable.combineLatest(
            a.startWith("EMPTY"),
            b,
            BiFunction<String, String, String> { a1, b1 -> a1 })
            .firstElement()
            .flatMap{ if (it == "EMPTY") Maybe.empty() else Maybe.just(it) }