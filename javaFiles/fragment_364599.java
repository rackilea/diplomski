private Subscriber<List<Integer>> loggingSubscriber2 = new SimpleSubscriber<List<Integer>>() {
    @Override
    public void onNext(List<Integer> integers) {
        Log.v(TAG, String.valueOf(integers.get(integers.size() - 1)));
    }
};

private void startObservableTests() {
    Observable<Integer> fileObserver = Observable.create(
            new Observable.OnSubscribe<Integer>() {
                @Override
                public void call(Subscriber<? super Integer> subscriber) {
                    for (int i = 1; i <= 9; i++) {
                        subscriber.onNext(i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    subscriber.onCompleted();
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    fileObserver.buffer(500, TimeUnit.MILLISECONDS).subscribe(loggingSubscriber2);
}