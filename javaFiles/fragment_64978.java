Subject<String> replaySubject = ReplaySubject.create();
replaySubject.subscribe(s -> System.out.println(s));

// elsewhere...

replaySubject.onNext("First");
replaySubject.onNext("Second");
replaySubject.onComplete();