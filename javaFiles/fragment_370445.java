public static void main(String[] args) {
    ExecutorService e=Executors.newSingleThreadExecutor(r -> new Thread(r, "sole thread"));
    CompletableFuture<?> f=CompletableFuture.runAsync(()->{}, e);
    f.join();
    f.thenRun(()->System.out.println("thenRun:\t"+Thread.currentThread()));
    f.thenRunAsync(()->System.out.println("thenRunAsync:\t"+Thread.currentThread()));
    f.thenRunAsync(()->System.out.println("thenRunAsync+e:\t"+Thread.currentThread()), e);
    e.shutdown();
}