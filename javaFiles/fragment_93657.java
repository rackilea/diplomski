ReplayProcessor<MyEvent> rp = ReplayProcessor.create();
Flux<MyEvent> interest1 = rp.filter(ev -> filterInterest1(ev));
Flux<MyEvent> interest2 = rp.filter(ev -> filterInterest2(ev));
Flux<MyEvent> interest1_2 = rp.filter(ev -> filterInterest1(ev) || filterInterest2(ev));

interest1.subscribe(doSomethingForInterest1);
interest2.subscribe(doSomethingForInterest2);
interest1_2.subscribe(doSomethingForInterest1_2);

rp.onNext(new MyEvent("interest1")); //subscriber 1 and 3 react
rp.onNext(new MyEvent("interest1")); //subscriber 1 and 3 react
rp.onNext(new MyEvent("interest2")); //subscriber 2 and 3 react
rp.onNext(new MyEvent("interest4")); // buffered until interest subscriber because ReplayProcessor

//shutdown/cleanup/close
rp.onComplete();