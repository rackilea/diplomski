PublishSubject<Object> subject = PublishSubject.create();
Observable<Object> observable1 = ...;
observable1.subscribe(subject);

subject.subscribe(...) // will eventually also get emisions from observable2

Observable<Object> observable2 = ...;
observable2.subscribe(subject);