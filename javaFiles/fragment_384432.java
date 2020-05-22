@Test
public void intervalObservableAndImmediateReaction() throws InterruptedException {
    Observable<String> obs = Observable.interval(1, TimeUnit.SECONDS)
                .cast(Object.class)                                          
                .mergeWith(
                          Observable.just("mockedUserClick")
                                    .delay(500, TimeUnit.MILLISECONDS))
                .flatMap(
                         timeOrClick -> Observable.just("Generated upon subscription")
                         );

    obs.subscribe(System.out::println);
    Thread.currentThread().sleep(3000); //to see the prints before ending the test
}