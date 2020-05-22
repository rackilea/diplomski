loginObservable()
   .switchMap( someData -> fetchUserDataObservable(someData) )
   .map( userData -> cacheUserData(userData) )
   .subscribe(new Subscriber<YourResult>() {
        @Override
        public void onCompleted() {
           // observable stream has ended - no more logins possible
        }
        @Override
        public void onError(Throwable e) {
            // do something
        }
        @Override
        public void onNext(YourType yourType) {
            displayUserData();
        }
    });