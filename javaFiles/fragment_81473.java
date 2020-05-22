public class UserLiveData extends LiveData<User> {
    public UserLiveData() {
        setValue(new User());
    }

    public UserLiveData(Headers headers) {
        Observable<User> observable = Observable.defer(new Callable<ObservableSource<? extends User>>() {
            @Override
            public ObservableSource<? extends User> call() throws Exception {
                User user = testService.getUserDetails(headers);
                return Observable.just(user);
            }
        });

        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DefaultObserver<String>() {
                @Override
                public void onNext(User value) {
                    setValue(value);
                }

                @Override
                public void onError(Throwable e) {
                    throw new RuntimeException(e);
                }

                @Override
                public void onComplete() {

                }
        });
    }
}