Scheduler single = Schedulers.newSingle("single-scheduler");
Flux.just("Bob")
        .flatMap(x -> {
            System.out.println(String.format(
                    "Saving person from thread %s", Thread.currentThread().getName()));
            return Mono.just(x).publishOn(Schedulers.elastic());
        })
        .flatMap(x -> {
            System.out.println(String.format(
                    "Finding person from thread %s", Thread.currentThread().getName()));
            return Mono.just(x).publishOn(Schedulers.elastic());
        })
        .flatMap(x -> {
            System.out.println(String.format(
                    "Deleting person from thread %s", Thread.currentThread().getName()));
            return Mono.just(x).publishOn(Schedulers.elastic());
        })
        .subscribeOn(single)
        .subscribe(aVoid -> System.out.println(String.format(
        "Subscription from thread %s", Thread.currentThread().getName())));