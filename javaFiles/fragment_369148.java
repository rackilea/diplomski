private <T> Observable<T> waitForTrue(Callable<T> callable) {
    return subject
    .filter(value -> value)
    .take(1)
    .observeOn(Schedulers.io())
    .map(value -> callable.call())
    .observeOn(AndroidSchedulers.mainThread());
}