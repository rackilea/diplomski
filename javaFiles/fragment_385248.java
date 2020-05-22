CompletableFuture<Boolean> receiver = CompletableFuture.supplyAsync(() -> {
    System.out.println("Async thread " + Thread.currentThread().getId());

    try {
        Thread.sleep(2000);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return true;
});

receiver.join();
Consumer<Boolean> consumer = (Boolean r) -> {
    System.out.println("Sync thread consume " + Thread.currentThread().getId());
};

consumer.accept(receiver.get());