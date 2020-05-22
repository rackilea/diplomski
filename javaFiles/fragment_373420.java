public class foo {

  //do normal class stuff.

  public void fooFunction(int n) {
    //do normal function things.

    executeThreads(n);
  }

  public void executeThreads(int n) throws InterruptedException {

    ExecutorService exec = Executors.newFixedThreadPool(n);
    List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();

    for(int i = 0; i < n; i++)
        tasks.add(Executors.callable(new Task(i)));

    exec.invokeAll(tasks);
    exec.shutdown();
  }

  public class Task implements Runnable {

    int taskNumber;

    public Task(int i) {

      taskNumber = i;

    }

    public void run() {
      try {
        //this gets run in a thread

        System.out.println("Thread number " + taskNumber);

      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

}