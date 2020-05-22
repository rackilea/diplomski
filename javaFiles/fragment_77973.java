BehaviorSubject<Integer> observable1 = BehaviorSubject.createDefault(-10000)  
BehaviorSubject<String>  observable2 = BehaviorSubject.createDefault("")

Observable.combineLates(
    observable1,
    observable2,
    (a, b) -> a + b
)
.subscribe(System.out::println)
;

observable1.onNext(1)  
observable1.onNext(2)  
observable2.onNext("Test")  
observable1.onNext(3)