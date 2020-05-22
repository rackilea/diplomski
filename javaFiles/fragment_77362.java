public class ParallelExecutor {
  interface ExecutionStep {
    List<ExecutionStep> execute();
  }

  public static final int N_THREADS = Runtime.getRuntime().availableProcessors();
  private final ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);

  public void execute(final ExecutionStep step) {
    executorService.submit(new Runnable() {
      @Override
      public void run() {
        for (ExecutionStep es : step.execute())
          execute(es);
      }
    });
  }

  public void stop() {
    this.executorService.shutdownNow();
  }
}