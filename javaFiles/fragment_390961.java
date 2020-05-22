private void case6() throws InterruptedException {

    final Observable<Integer> o = canBeRetriedBetter(2).retry(2).cache();

    check("case 6", o);

    this.done.await();
}