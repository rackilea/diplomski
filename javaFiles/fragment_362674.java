@Test
public void shouldSubscribeToSubjectToObservable() throws InterruptedException {
    Observable<Integer> observable = Observable.just(1, 2);
    PublishSubject<Object> subject = PublishSubject.create();
    subject.subscribe(o -> {
        System.out.println("o = " + o);
    });

    observable.subscribe(subject);

    Thread.sleep(1000);
}