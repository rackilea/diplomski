val o1: Observable<Int> = Observable.just(1, 2, 3)
val o2: Observable<Int> = Observable.just(4).delay(100,TimeUnit.MILLISECONDS)
val observable: Observable<Int> = Observable.concat(o1, o2)
val subject = BehaviorSubject.create<Int>()
observable.subscribe(subject)
subject.subscribe{
    result ->
    System.out.println("Start $result in Subscription Result")
}
Thread.sleep(1000)