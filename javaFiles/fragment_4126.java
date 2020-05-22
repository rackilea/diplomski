Observable<String> stringObservable = Observable.just("Hello world")
        .doOnNext(System.out::println)
        .ignoreElements();
Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6)
        .doOnNext(System.out::println)
        .ignoreElements();

Observable.merge(stringObservable, integerObservable)
        .subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                System.out.println("Finished!");
            }

            @Override
            public void onError(Throwable throwable) {
                /*optionally handle if one of the observables calls onError()*/
            }

            @Override
            public void onNext(Object o) { /*not called*/ }
        });