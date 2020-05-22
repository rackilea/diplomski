public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureTest::counting).whenComplete((result, exception) -> {
        if (exception != null) {
            System.out.println(result);
        } else {
        }
    });

    System.out.println("xD");
    Integer value = future.get();
}