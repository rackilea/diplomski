public class TaskDelimitingTest {

  private enum Tasks {TASK1, TASK2};

  private static ConcurrentHashMap<Tasks, AtomicInteger> taskObserver = new ConcurrentHashMap<>();

  public static class Task implements Runnable {

    private static final Random random = new Random(System.currentTimeMillis());

    private final Semaphore sem = new Semaphore(6, true);
    private final Tasks task;

    public Task(Tasks task) {
      this.task = task;
    }

    @Override
    public void run() {
      try {
        taskObserver.get(task).incrementAndGet();
        Thread.sleep(random.nextInt(1000));
        taskObserver.get(task).decrementAndGet();
        sem.release();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    public void postToExecution(ExecutorService executor) {
      try {
        sem.acquire();
        executor.execute(this);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static class Task1 extends Task {

    public Task1() {
      super(Tasks.TASK1);
    }

  }

  public static class Task2 extends Task {

    public Task2() {
      super(Tasks.TASK2);
    }

  }

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(12);

    Thread t1 = new Thread(() -> {
      taskObserver.put(Tasks.TASK1, new AtomicInteger());
      IntStream.rangeClosed(1, 100).forEach(i -> {
        new Task1().postToExecution(executor);
        System.out.println(taskObserver);
      });
    });
    Thread t2 = new Thread(() -> {
      taskObserver.put(Tasks.TASK2, new AtomicInteger());
      IntStream.rangeClosed(1, 100).forEach(i -> {
        new Task2().postToExecution(executor);
        System.out.println(taskObserver);
      });
    });
    t1.start();
    t2.start();
  }

}