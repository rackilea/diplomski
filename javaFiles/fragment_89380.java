public static Completable fromCallable(final Callable<?> callable) {
    requireNonNull(callable);
    return create(new OnSubscribe() {
        @Override
        public void call(rx.CompletableSubscriber s) {
            BooleanSubscription bs = new BooleanSubscription();
            s.onSubscribe(bs);
            try {
                // calls the callable regardless
                callable.call();
            } catch (Throwable e) {
                if (!bs.isUnsubscribed()) {
                    s.onError(e);
                }
                return;
            }
            // the emission of the complete is guarded
            if (!bs.isUnsubscribed()) {
                s.onCompleted();
            }
        }
    });
}