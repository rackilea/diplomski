Future<Result> futureResult = serviceClass.getResult("foo");

    try {
        Result result = futureResult.get();
        // do something with result
    }
    catch (ExecutionException ee) {
        Throwable e = ee.getCause();
        // do something with e
    }