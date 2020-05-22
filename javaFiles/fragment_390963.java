private void case7() throws InterruptedException {

    final Observable<Integer> o = canBeRetriedBetter(2).compose(new RetryAndCache(2));

    check("case 7", o);

    this.done.await();
}