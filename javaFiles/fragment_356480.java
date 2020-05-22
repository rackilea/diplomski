Flux.create(sink -> ... /* listens to and receives from external source */ , FluxSink.OverflowStrategy.LATEST)
    .flatMap(map -> Mono.when(
        redisHashReactiveCommands.hmset(key, map)
            .subscribeOn(Schedulers.parallel())
            .doOnNext(s -> log.debug("Redis consumed. Result -> {}", s)),

        kafkaReactiveCommand.something(map)
            .subscribeOn(Schedulers.parallel())
            .doOnNext(s -> log.debug("Kafka consumed. Result -> {}", s)),
    ))
    //... this results in a Mono<Void>
    .doOnComplete(() -> log.debug("Both redis and kafka completed."))
    .doOnError(exception -> log.error("Error occurred while consuming message", exception))
    .subscribe();