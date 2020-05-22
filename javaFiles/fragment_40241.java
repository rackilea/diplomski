Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

final Flux<String> flux = Flux
        .range(1, 2)
        .map(i -> 10 + i)
        .subscribeOn(s)
        .doOnNext(value -> System.out.println(
                "[doOnNext] " + Thread.currentThread().getName() + " value: " + value))
        .doOnSubscribe(sub -> System.out.println(
                "[doOnSubscribe] " + Thread.currentThread().getName()));

flux.subscribe();

Thread.sleep(1000);