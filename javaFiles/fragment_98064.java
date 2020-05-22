reateObservable()
            .subscribeOn(Schedulers.newThread())
            .observeOn(Schedulers.newThread())
            .subscribe(message -> {
                System.out.println("Case 3 Observable thread " + message);
                System.out.println("Case 3 Observer thread " + Thread.currentThread().getName());
            });
            //will print:
            //Case 3 Observable thread RxNewThreadScheduler-2
            //Case 3 Observer thread RxNewThreadScheduler-1