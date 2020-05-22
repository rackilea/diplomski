@Async("someExecutor")
public Future<String> asyncService() {

    return CompletableFuture.completedFuture("start").thenApply(s->{

    System.out.println(Thread.currentThread().getName()+" - "+Thread.currentThread().getThreadGroup());
        return "hello";
    });     
}