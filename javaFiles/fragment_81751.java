Flux<Object> load(String token, final Function<String, Mono<Page>> fct) {
    return fct.apply(token).flatMapMany(page -> {
        if (page.token == null) {
            // no more pages
            return Flux.fromIterable(page.entities);
        }

        return Flux
                .fromIterable(page.entities)
                .concatWith(
                        // Flux.defer(() -> load(page.token, fct))
                        Flux.create(s -> {
                            DelegateSubscriber[] ref = new DelegateSubscriber[1];

                            s.onRequest(l -> {
                                if (ref[0] == null) {
                                    ref[0] = new DelegateSubscriber(s);
                                    load(page.token, fct).subscribe(ref[0]);
                                }
                                ref[0].request(l);
                            });
                        }));
    });
}

static class DelegateSubscriber extends BaseSubscriber<Object> {

    FluxSink<Object> delegate;

    public DelegateSubscriber(final FluxSink<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        // nothing
    }

    @Override
    protected void hookOnNext(Object value) {
        delegate.next(value);
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        delegate.error(throwable);
    }
}