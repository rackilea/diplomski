class MyCustomBackpressureSubscriber<T> extends BaseSubscriber<T> {

    int consumed;
    final int limit = 5;

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        request(limit);
    }

    @Override
    protected void hookOnNext(T value) {
        // do business logic there 

        consumed++;

        if (consumed == limit) {
            consumed = 0;

            request(limit);
        }
    }
}