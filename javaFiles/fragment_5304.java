public class TaskRunner {
  private static class PriorityRunnable implements Runnable,
            Comparable<PriorityRunnable> {
    private Runnable theRunnable;
    private int priority = 0;
    public PriorityRunnable(Runnable r, int priority) {
      this.theRunnable = r;
      this.priority = priority;
    }

    public int getPriority() {
      return priority;
    }

    public void run() {
      theRunnable.run();
    }

    public int compareTo(PriorityRunnable that) {
      return this.priority - that.priority;
    }
  }

  private BlockingQueue<Runnable> taskQueue = new PriorityBlockingQueue<Runnable>();

  private ThreadPoolExecutor exec = new ThreadPoolExecutor(8, 8, 0L,
            TimeUnit.MILLISECONDS, taskQueue);

  public void runTasks(Runnable... tasks) {
    int priority = 0;
    Runnable nextTask = taskQueue.peek();
    if(nextTask instanceof PriorityRunnable) {
      priority = ((PriorityRunnable)nextTask).getPriority() + 1;
    }
    for(Runnable t : tasks) {
      exec.execute(new PriorityRunnable(t, priority));
      priority += 100;
    }
  }
}