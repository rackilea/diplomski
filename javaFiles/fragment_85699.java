class CustomTransformer<T> implements Observable.Transformer<T, T> {

    private final ViewManager viewManager;
    private final Context context;

    CustomTransformer(ViewManager viewManager, Context context) {
        this.viewManager = viewManager;
        this.context = context;
    }

    @Override
    public Observable<T> call(Observable<T> apiCall) {
        return apiCall
                .observeOn(AndroidSchedulers.mainThread())
                .startWith(Observable.defer(() -> {
                    if (!NetworkUtils.isConnected(context)) {
                        return Observable.error(new ConnectException("network not connected"));
                    } else {
                        return Observable.empty();
                    }
                }))
                .doOnSubscribe(() -> viewManager.showLoader())
                .doOnCompleted(() -> viewManager.hideLoader())
                .doOnError(throwable -> viewManager.hideLoader());
        ;
    }
}