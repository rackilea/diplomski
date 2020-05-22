public class Test {
  public static void main (String []args) throws  InterruptedException
  {
    ExecutorService exSer = Executors.newFixedThreadPool(4);
    exSer.submit(new ExecutorThing());
    exSer.submit(new ExecutorThing());
    exSer.submit(new ExecutorThing());
    exSer.submit(new ExecutorThing());
    exSer.shutdownNow();
  }
}

class ExecutorThing implements Callable<Object> {
  public Object call() throws InterruptedException  {
    while (!(currentThread().isInterrupted()))
      System.out.println(currentThread().isInterrupted());
    return null;
  }
}