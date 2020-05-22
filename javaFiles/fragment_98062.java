createObservable().subscribe(message -> {
        System.out.println("Case 1 Observable thread " + message);
        System.out.println("Case 1 Observer thread " + Thread.currentThread().getName());
    });
    //will print:
    //Case 1 Observable thread main
    //Case 1 Observer thread main