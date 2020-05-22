ConnectableObservable<String> observableOne = Observable
        .just("{1}")
        .map(v -> {
          System.out.println("Executing Observable 1");
          return v;
        }).publish();

    Observable<String> observableTwo = observableOne
        .map(observableOneValue -> {
          System.out.println("Executing Observable 2");
          return "{2"+observableOneValue+"}";
        });

    Observable.zip(
        observableOne,
        observableTwo,
        (observableOneValue, observableTwoValue) ->
        {
          System.out.println("Executing Observable 3");
          return "{3"+observableOneValue+observableTwoValue+"}";
        }
    ).subscribe(System.out::println);

    // Call when all the subscribers are ready --
    observableOne.connect();