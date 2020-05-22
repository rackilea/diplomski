package de.scrum_master.app;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Parent {
  private ExecutorService executorService;

  @MDCTrace
  public Runnable runMultiThreadByExecutorAnnotated(Runnable runnable) throws InterruptedException {
    return doStuff(runnable);
  }

  @MDCTrace
  public Runnable runMultiThreadByExecutorAnnotated() throws InterruptedException {
    return doStuff();
  }

  public Runnable runMultiThreadByExecutorPlain() throws InterruptedException {
    return doStuff();
  }

  public Runnable runMultiThreadByExecutorPlain(Runnable runnable) throws InterruptedException {
    return doStuff(runnable);
  }

  private Runnable doStuff() throws InterruptedException {
    return doStuff(new Child());
  }

  private Runnable doStuff(Runnable runnable) throws InterruptedException {
    executorService = Executors.newCachedThreadPool();
    System.out.println(String.format("[%d] Before start child thread", Thread.currentThread().getId()));

    executorService.submit(runnable);
    System.out.println(String.format("[%d] After start child thread", Thread.currentThread().getId()));

    List.of(10, 11, 12, 13, 14).parallelStream().forEach(i -> {
      //System.out.println(String.format("[%d] Loop iteration #%d", Thread.currentThread().getId(), i));
    });

    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.SECONDS);
    System.out.println(String.format("[%d] ExecutorService is over", Thread.currentThread().getId()));
    System.out.println("\n----------------------------------------\n");
    return runnable;
  }

  public static void main(String[] args) throws InterruptedException {
    Parent parent = new Parent();
    System.out.println("MDCTrace annotation");
    parent.runMultiThreadByExecutorAnnotated();
    System.out.println("No annotation");
    parent.runMultiThreadByExecutorPlain();

    Runnable runnable = new Child();
    System.out.println("MDCTrace annotation (runnable created outside of control flow)");
    parent.runMultiThreadByExecutorAnnotated(runnable);
    System.out.println("No annotation (re-use runnable created outside of control flow)");
    parent.runMultiThreadByExecutorPlain(runnable);

    System.out.println("MDCTrace annotation (save returned runnable)");
    runnable = parent.runMultiThreadByExecutorAnnotated();
    System.out.println("No annotation (re-use returned runnable)");
    parent.runMultiThreadByExecutorPlain(runnable);
}
}