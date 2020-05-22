private Observable<Integer> method() {
    return Observable.defer(() -> {
        // some work
        return Observable.just(1);
    });
}