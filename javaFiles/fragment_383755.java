public static <T> T boomProtector(Callable<T> thingThatMightGoBoom) {
  try {
    return thingThatMightGoBoom.call();
  }
  catch(Exception e) {
    // TODO: your standard catch logic
  }

  return null;
}