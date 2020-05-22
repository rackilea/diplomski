private void case5() throws InterruptedException {
    // Same as case 3 but using defer
    final Observable<Integer> o = Observable.defer(() -> canBeRetried(2)).retry(2).cache();

    check("case 5", o);

    this.done.await();
}