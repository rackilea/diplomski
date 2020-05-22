PublishSubject<Boolean> property1 = PublishSubject.create();
PublishSubject<Boolean> property2 = PublishSubject.create();

Observable.combineLatest(property1,
                         property2,
                         (propertyOneValue, propertyTwoValue) -> propertyOneValue && propertyTwoValue)
          .subscribe(isValid -> doWork(isValid));

// sometime later
property1.onNext(true);
property2.onNext(true);