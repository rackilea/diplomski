class Main {
  private static final ExecutorService es = Executors.newCachedThreadPool();

  public static void main(final String... args) throws Throwable {
    List<Future<Integer>> results = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      results.add(asyncSum(i, i*i));
    }
    // here, in the main thread, you can do whatever you want
    // while the calculations are performed in background threads
    // ...

    // after the main thread finishes what it was doing, it
    // can process the futures
    for (final Future<Integer> result : results) {
      System.out.println(result.get());
    }
  }

  // this method launches a calculation on a worker thread and immediately
  // returns a Future, which is a reference to the result of the calculation
  // once it is completed
  private static Future<Integer> asyncSum(final int a, final int b) {
    return es.submit(new Callable<Integer>() {
      @Override public Integer call() throws Exception {
        return a + b;
      }
    });
  }
}