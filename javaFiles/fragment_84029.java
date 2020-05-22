when(isChanged()).thenReturn(subject);

TestObserver<Boolean> to = myFunc().test();

subject.onNext(true);
subject.onNext(false);

to.assertValueCount(1);