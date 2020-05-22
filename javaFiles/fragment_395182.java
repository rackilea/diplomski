ExecutorService executionService = Executors.newFixedThreadPool(5);
Set<CompletableFuture<?>> tasks = ConcurrentHashMap.newKeySet();
AtomicBoolean canceled = new AtomicBoolean();

for(int i = 0; i < 1000; i++) {
    final int id = i;
    CompletableFuture<?> c = CompletableFuture
        .runAsync(() -> {
            System.out.println("Running: " + id); 
            if(id == 400) throw new RuntimeException("Exception from: " + id);
        }, executionService);
        c.whenComplete((v, ex) -> {
            if(ex != null && canceled.compareAndSet(false, true)) {
                System.out.println("Canceling.");
                for(CompletableFuture<?> f: tasks) f.cancel(false);
                System.out.println("Canceled.");
            }
        });
    tasks.add(c);
    if(canceled.get()) {
        c.cancel(false);
        break;
    }
}

try {
    CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();
} catch(Exception e) {
    System.out.println("Got async exception: " + e);
} finally {
    System.out.println("DONE");
}
executionService.shutdown();