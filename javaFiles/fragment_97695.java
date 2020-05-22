@Async("threadPoolTaskExecutor")
@Override
public CompletableFuture<Void> myAsyncFunction(String s) {

    session.setAttribute("key", s);
    return new CompletableFuture<Void>();
}