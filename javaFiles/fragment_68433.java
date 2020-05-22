public static void main(String[] args) {
    Flowable<String> f1 = Flowable.just("a", "b", "c", "d", "e");
    Flowable<String> f2 = Flowable.just("z", "x", "y");


    f1.doOnNext(n -> System.out.println("action on " + n))
      .take(3)
      .subscribe(System.out::println);

    System.out.println("------------------------");
    System.out.println("Other possible use case:");
    System.out.println("------------------------");

    f1.doOnNext(n -> System.out.println("another action on " + n))
      .buffer(3)
      .flatMap(l -> Flowable.fromIterable(l).map(s -> "Hello " + s))
      .subscribe(System.out::println);

    Flowable.timer(10, SECONDS) // Just to block the main thread for a while
            .blockingSubscribe();
}