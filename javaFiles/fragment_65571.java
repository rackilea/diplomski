...

  promise = promise.recover(new F.Function<Throwable, String>() {

    public String apply(Throwable t) throws Throwable {
      Logger.error("Error ->", t);
      return "error";
    }
  });

  return promise;