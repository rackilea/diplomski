TestObserver<Object> observer= TestObserver.create(); 
Observable<Object> dataLocatorSubject = this.target.getObservable();
DataMessage data = new DataMessage();

// subscribe first
dataLocatorSubject.subscribe(observer);
// signal next
this.target.handleData(data);

observer.assertSubscribed();
observer.awaitCount(1);
observer.assertValueCount(1);