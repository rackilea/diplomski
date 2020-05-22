ExecutionContext myExecutionContext = Akka.system().dispatchers().lookup("my-context");
    return async(
            Akka.asPromise(Futures.future(new Callable<String>() {
              public String call() {
                return doSth();
              }   
            }, myExecutionContext)).map(new F.Function<String,Result>() {
              public Result apply(String i) {
                return ok(i);
              }
            })
    );