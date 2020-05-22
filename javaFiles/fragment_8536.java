public class ExecutorMain {
   public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
      ScheduledThreadPoolExecutor scheduledExecutorService = new ScheduledThreadPoolExecutor(2);
      scheduledExecutorService.scheduleAtFixedRate(new ShortTask(1, 5000), 0, 3, TimeUnit.SECONDS);
      scheduledExecutorService.scheduleAtFixedRate(new ShortTask(2, 5000), 0, 3, TimeUnit.SECONDS);
      scheduledExecutorService.scheduleAtFixedRate(new LongTask(1, 5000), 0, 10, TimeUnit.SECONDS);
      scheduledExecutorService.scheduleAtFixedRate(new LongTask(2, 5000), 0, 10, TimeUnit.SECONDS);
   }
}

class Worker extends Thread {
  private final Process process;
  private Integer exit;
  String id;
  Worker(Process process, String id) {
    this.process = process;
    this.id = id;
  }
  public void run() {
    try {
        exit = process.waitFor();
    } catch (InterruptedException ignore) {
        //NOOP
    }
}

public Integer getExit() {
    return exit;
  }
}

class ShortTask implements Runnable {
  private int id;
  private long timeOut;
  ShortTask(int id, long timeOut) {
    this.id = id;
    this.timeOut = timeOut;
  }
  public void run() {

    long start = System.currentTimeMillis();

    Runtime runtime = Runtime.getRuntime();
    Process process = null;
    try {
        process = runtime.exec("sleep 1s");
    } catch (IOException e) {
        System.out.println("ShortTask IOE");
    }
    Worker worker = new Worker(process, "short task"+id);
    worker.start();
    try {
        worker.join(timeOut);
        long total = System.currentTimeMillis()-start;
        //If time out, exit code would be null
        System.out.println(" Short task id :"+id+" Exit Code : " +worker.getExit()+" thread id "+Thread.currentThread().getId()+" in time "+total);
    } catch(InterruptedException ex) {
        worker.interrupt();
        Thread.currentThread().interrupt();
    } finally {
        if(process != null) {
            process.destroy();
        }
    }
}
}

class LongTask implements Runnable {
  private int id;
  private long timeOut;
  LongTask(int id, long timeOut) {
    this.id = id;
    this.timeOut = timeOut;
  }
  public void run() {

    long start = System.currentTimeMillis();

    Runtime runtime = Runtime.getRuntime();
    Process process = null;
    try {
        process = runtime.exec("sleep 60s");
    } catch (IOException e) {
        System.out.println("LongTask IOE");
    }
    Worker worker = new Worker(process, "long task"+id);
    worker.start();
    try {
        worker.join(timeOut);
        long total = System.currentTimeMillis() - start;
        //If time out, exit code would be null
        System.out.println(" Long Task id :"+id+" Exit Code : " +worker.getExit()+" thread id "+Thread.currentThread().getId()+" in time "+total);
    } catch(InterruptedException ex) {
        worker.interrupt();
        Thread.currentThread().interrupt();
    } finally {
        if(process != null) {
            process.destroy();
        }
    }
  }
}