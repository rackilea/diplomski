public class TestMain {

public static void main(String[] args) {

    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        System.out.println(Thread.currentThread().getName());
        return "hello";
    });
    CompletableFuture<Integer> intFuture = future.thenApply(s -> {
        System.out.println(Thread.currentThread().getName());
        return s.length();
    });

    CompletableFuture<Integer> intFuture2 = future.thenApply(s -> {
        System.out.println(Thread.currentThread().getName());
        return s.length();
        });
       future.complete("hello");

     }

 }