import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaExample {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService exec = Executors.newCachedThreadPool();
    Observable<String> hello = Observable.fromCallable(() -> getHello())
        .subscribeOn(Schedulers.from(exec));

    hello.subscribe();

    System.out.println("End of main!");

    exec.shutdown();
    exec.awaitTermination(10, TimeUnit.SECONDS);
  }

  public static String getHello() {
    System.out.println("Hello called in " + Thread.currentThread().getName());
    return "Hello";
  }
}