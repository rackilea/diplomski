createObservable()
            .observeOn(Schedulers.newThread())
            .subscribe(message -> {
                System.out.println("Case 4 Observable thread " + message);
                System.out.println("Case 4 Observer thread " + Thread.currentThread().getName());
            });
            //will print:
            //Case 4 Observable thread main
            //Case 4 Observer thread RxNewThreadScheduler-1