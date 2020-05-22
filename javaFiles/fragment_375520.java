static Observable<Integer> getDataSync(int i) {
    return Observable.create(new Observable.OnSubscribe<Integer> {
        @Override
        public void call(Subscriber<? super Integer> s) {
            // simulate latency
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            s.onNext(i);
            s.onCompleted();
        }
    });
}