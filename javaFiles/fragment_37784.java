public interface Locks {

    Mono<ReactiveDistributedLock> doLock(LockParams params);

    Mono<Boolean> doUnlock(ReactiveDistributedLock lock);

    default <T> Mono<T> withLock(LockParams params, Supplier<Mono<T>> stage) {
        return doLock(params)
                .flatMap(lock -> 
                    stage.get()
                         .flatMap(value -> 
                            doUnlock(lock)
                            .then(Mono.just(value))
                         )
                );
    }
}