ExecutorService executor = Executors.newSingleThreadExecutor;

ObservableOnSubscribe<SomeClassTBD> handler = emitter ->
  executor.submit(() -> {
    try {
      //liveStream code here
      emitter.onComplete();
    }
    catch(Exception e) {
      emitter.onError(e);
    }
    finally {
      // Cleanup here
    }
  });
  Observable<SomeClassTBD> = Observable.create(handler);