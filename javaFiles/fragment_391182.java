enum ValueLessSignal {
    IGNORE_ME;
}

PublishSubject<ValueLessSignal> subject = PublishSubject.create();

subject.subscribe(ignore -> { System.out.println("Something happened"); })

subject.onNext(ValueLessSignal.IGNORE_ME);