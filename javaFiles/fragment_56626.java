Flux.just("a", "b", "c", "d")
            .log(null, Level.INFO, true) // line: 18
            .flatMap(value ->
                    Mono.just(value.toUpperCase()).publishOn(Schedulers.elastic()), 2)
            .log(null, Level.INFO, true) // line: 21
            .take(3)
            .log(null, Level.INFO, true) // line: 23
            .subscribe(x ->
                    System.out.println("Thread: " + Thread.currentThread().getName() +
 " , " + x), t -> {}, () -> System.out.println("Completed ""Only Once"));