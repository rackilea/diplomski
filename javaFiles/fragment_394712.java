@Test
public void name() throws Exception {
    final List<String> names = new ArrayList<String>() {{
        add("Ringo");
        add("John");
        add("Paul");
        add("George");
    }};

    Observable<String> stringObservable = Observable.fromIterable(names)
            .flatMap(s -> {
                return longWork(s).doOnNext(s1 -> {
                    printCurrentThread(s1);
                }).subscribeOn(Schedulers.newThread());
            });

    TestObserver<String> test = stringObservable.test();

    test.awaitDone(2_000, TimeUnit.MILLISECONDS).assertValueCount(4);
}

private Observable<String> longWork(String s) throws InterruptedException {
    return Observable.fromCallable(() -> {
        Thread.sleep(1_000);

        return s;
    });
}

private void printCurrentThread(String additional) {
    System.out.println(additional + "_" + Thread.currentThread());
}