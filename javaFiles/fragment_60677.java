public static <T> Observable<String> makeToStringObservable(final Callable<T> func) {
    return Observable.create(
            new Observable.OnSubscribe<T>() {
                @Override
                public void call(Subscriber<? super T> subscriber) {
                    try {
                        T observed = func.call();
                        if (observed != null) { // to make defaultIfEmpty work
                            subscriber.onNext(observed);
                        }
                        subscriber.onCompleted();
                    } catch (Exception ex) {
                        subscriber.onError(ex);
                    }
                }
            }).map(new Func1<T, String>() {
                @Override
                public String call(T t) {
                  //toString() is a method that is always there, yay
                  return t.toString();
            }
    });