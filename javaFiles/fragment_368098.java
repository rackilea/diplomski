final ExecutorService subjects = Executors.newFixedThreadPool(2);
subjects.submit(new Runnable() {

  public void run() {
    while (!Thread.interrupted()) {
      Thread.yield();
    }
    System.out.println("subject 1 stopped!");
  }
});
subjects.submit(new Runnable() {

  public void run() {
    while (!Thread.interrupted()) {
      Thread.yield();
    }
    System.out.println("subject 2 stopped!");
  }
});
final ScheduledExecutorService coordinator = Executors.newSingleThreadScheduledExecutor();
coordinator.schedule(new Runnable() {

  public void run() {
    System.out.println("coordinator stopping!");
    subjects.shutdownNow();
    coordinator.shutdown();
  }
}, 500, TimeUnit.MILLISECONDS);