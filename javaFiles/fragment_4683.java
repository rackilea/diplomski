static BlockingQueue<Future<?>> PENDING = …;
static int MAX_ITEMS_PER_JOB = …;
…
/*scheduling code …*/new Runnable() {
  public void run()
  {
    ArrayList<Future<?>> myLocalItems=new ArrayList<>();
    PENDING.drainTo(myLocalItems, MAX_ITEMS_PER_JOB);
    for(Future<?> f:myLocalItems) {
      if(!f.isDone()) PENDING.offer(f); // re-queue
      try {
        f.get();
      } catch(ExecutionException ex) {
        handleException(ex.getCause());
      }
    }
  }
};