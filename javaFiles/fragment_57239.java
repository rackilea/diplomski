ArrayList<CompletableFuture<String>> list = new ArrayList<>();
ArrayList<CompletableFuture<?>> dependents = new ArrayList<>();
for (int i = 0; i <100; i++) {
    CompletableFuture<String> stringCompletableFuture = new CompletableFuture<>();
    CompletableFuture<?> thisWillHaveException = stringCompletableFuture.whenCompleteAsync((e, a) -> {
        System.out.println("Complete " + e);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e1) {e1.printStackTrace();}
    }, executorService);
    dependents.add(thisWillHaveException);
    list.add(stringCompletableFuture);
}

for (int i = 0; i < list.size(); i++) {
    list.get(i).complete(i + "");
}
Thread.sleep(2000);
dependents.forEach(cf -> {
    cf.whenComplete((r, e) -> {
        if (e != null)
            System.out.println(cf + " " + e.getMessage());
    });
});