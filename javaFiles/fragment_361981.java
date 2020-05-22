private Disposable mDisposable;

public abstract class MainPresenter<T> {
protected Disposable subscribe(Observable<T> observable, DisposableObserver<T> observer) {
mDisposable = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(observer);

return mDisposable;

}