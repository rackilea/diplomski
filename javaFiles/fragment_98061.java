public static Observable<String> createObservable(){
        return Observable.create((Subscriber<? super String> subscriber) -> {
                subscriber.onNext(Thread.currentThread().getName());
                subscriber.onCompleted();
            }
        );
    }