final ExecutionContext ec = system.dispatcher();

Future<Integer> future = future(new Callable<Integer>() {
  public Integer call() {
    return 1 / 0;
  }
}, ec).recover(new Recover<Integer>() {
  public Integer recover(Throwable problem) throws Throwable {
    if (problem instanceof ArithmeticException)
      return 0;
    else
      throw problem;
  }
}, ec);

future.onSuccess(new PrintResult<Integer>(), system.dispatcher());