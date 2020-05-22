class Main {
  public static void main(String[] args) throws Throwable {
    final ExecutorService es = Executors.newCachedThreadPool();
    final CompletionService<Integer> cs = new ExecutorCompletionService<>(es);

    submitSomeCalculations(cs);

    while (true) {
      doMainThreadWork();
      processFinishedCalculations(cs);
    }
  }

  private static void submitSomeCalculations(final CompletionService<Integer> cs) {
    for (int i = 0; i < 10; i++) {
      submitAsyncSum(cs, i, i * i);
    }
  }

  private static void submitAsyncSum(final CompletionService<Integer> cs, final int a, final int b) {
    cs.submit(new Callable<Integer>() {
      @Override public Integer call() throws Exception {
        Thread.sleep(100 + (long) (Math.random() * 900));
        return a + b;
      }
    });
  }

  private static void processFinishedCalculations(final CompletionService<Integer> cs) throws ExecutionException, InterruptedException {
    while (true) {
      final Future<Integer> result = cs.poll();
      if (result == null) {
        System.out.println("> no finished results...");
        break;
      } else {
        System.out.println("> result available: " + result.get());
      }
    }
  }

  static void doMainThreadWork() {
    System.out.println("work from main thread...");
  }
}