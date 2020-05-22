createObservable()
            .subscribeOn(Schedulers.newThread())
            .subscribe(message -> {
                System.out.println("Case 2 Observable thread " + message);
                System.out.println("Case 2 Observer thread " + Thread.currentThread().getName());
            });
            //will print:
            //Case 2 Observable thread RxNewThreadScheduler-1
            //Case 2 Observer thread RxNewThreadScheduler-1