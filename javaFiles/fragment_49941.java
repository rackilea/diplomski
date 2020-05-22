Flux<String> source = Flux.just("a", "b", "c");
source.subscribe(new Subscriber<String>() {
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1); // <-- here
    }

    @Override
    public void onNext(String s) {
        subscription.request(1); // <-- here
        System.out.println(s);
    }

    @Override
    public void onError(Throwable t) {
    }

    @Override
    public void onComplete() {
    }
});