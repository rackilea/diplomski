public void method(int id) throws InterruptedException, ExecutionException {
    CompletableFuture<String> cfa = CompletableFuture.supplyAsync(() -> generateA(id));
    CompletableFuture<String> cfb = CompletableFuture.supplyAsync(() -> generateB(id));
    String fooA = cfa.get();
    String fooB = cfb.get();
    System.out.println("Final fooA " + fooA);
    System.out.println("Final fooB " + fooB);
}

public String generateA(int id) {
    System.out.println("Entering generateA " + Thread.currentThread());
    sleep(2000);
    System.out.println("Leaving generateA");
    return "A" + id;
}

public String generateB(int id) {
    System.out.println("Entering generateB " + Thread.currentThread());
    sleep(1000);
    System.out.println("Leaving generateB");
    return "B" + id;
}

private void sleep(int n) {
    try {
        Thread.sleep(n);
    } catch (InterruptedException ex) {
        // never mind
    }
}