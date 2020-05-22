Observable.defer {
    try {
        Observable.just(...)
    } catch(e: Throwable) {
        Observable.error(e)
    }
}