Observable<JSONObject> = someMethodCall().flatMap( x -> {
    try {
      //do something....
      return Observable.just(new JSONObject().put("id", 12346"));
    } catch (Throwable t) {
      return Observable.error(t);
    }
  });