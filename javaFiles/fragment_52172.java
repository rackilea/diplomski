public class Interrupted {

  static final List<Thread> THREADS = Arrays.asList(
      new Thread(new Sleep()),
      new Thread(new SystemIn())
  );
  static final CountDownLatch LATCH = new CountDownLatch(THREADS.size());

  public static void main(String[] args) throws Exception {
    Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook()));
    for (Thread thread : THREADS) {
      thread.start();
    }
    System.out.println("[main] Waiting for threads to start...");
    LATCH.await();
    System.out.println("[main] All started, time to exit");
    System.exit(0);
  }

  static abstract class BlockingTask implements Runnable {
    @Override
    public void run() {
      final String name = getClass().getSimpleName();
      try {
        LATCH.countDown();
        System.out.printf("[%s] is about to block...%n",name);
        blockingTask();
      } catch (Throwable e) {
        System.out.printf("[%s] ", name);
        e.printStackTrace(System.out);
      } finally {
        System.out.printf("[%s] finally%n", name);
      }
    }
    abstract void blockingTask() throws Throwable;
  }

  static class Sleep extends BlockingTask {
    @Override
    void blockingTask() throws Throwable {
      Thread.sleep(60 * 60 * 1000); // 1 hour
    }
  }

  static class SystemIn extends BlockingTask {
    @Override
    void blockingTask() throws Throwable {
      System.in.read();
    }
  }

  static class ShutdownHook implements Runnable {
    @Override
    public void run() {
      System.out.println("[shutdown-hook] About to interrupt blocking tasks...");
      for (Thread thread : THREADS) {
        thread.interrupt();
      }
      System.out.println("[shutdown-hook] Interrupted");
      try {
        for (int i=0; i<10; i++) {
          Thread.sleep(50L);
          System.out.println("[shutdown-hook] Still exiting...");
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}