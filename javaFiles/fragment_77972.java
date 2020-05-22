PublishSubject<Integer> observable1 = PublishSubject.create()  
PublishSubject<String>  observable2 = PublishSubject.create()

Observable.combineLates(
    observable1.startWith(-100000),
    observable2.startWith(""),
    (a, b) -> a + b
)
.subscribe(System.out::println)
;

observable1.onNext(1)  
observable1.onNext(2)  
observable2.onNext("Test")  
observable1.onNext(3)