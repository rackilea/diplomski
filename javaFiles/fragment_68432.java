private static void main() {
    Flowable<String> f2 = Flowable.just("a", "b", "c", "d", "e");
    Flowable<String> f1 = Flowable.just("z", "x", "y");

    f2.doOnNext(n -> System.out.println("saving " + n))
      .concatWith(f1)
      .subscribe(System.out::println);

    Flowable.timer(10, SECONDS) // Just to block the main thread for a while
            .blockingSubscribe();
}