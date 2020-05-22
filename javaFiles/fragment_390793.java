Observable<MyObject> observable = Observable.defer(new Func0<Observable<MyObject>>() {
    @Override
    public Observable<MyObject> call() {

        System.out.println(Looper.myLooper() + " - " + Looper.getMainLooper());

        try {
            MyObject myObject = new MyObject();
            return Observable.just(myObject);
        }
        catch (Exception e) {
            return Observable.error(e);
        }

    }
});

Subscription s = observable
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
                new Action1<MyObject>() {
                    @Override
                    public void call(MyObject myObject) {

                    }
                },
                new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
        );