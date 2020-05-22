val observable : Observable<Int> = Observable.just(1, 2, 3)
val subject = ReplaySubject.createWithSize<Int>(1)
observable.takeLast(1).subscribe(subject) //can be moved after subject.subscribe as well
subject.subscribe{
    result ->
    System.out.println("Start $result in Subscription Result")
}