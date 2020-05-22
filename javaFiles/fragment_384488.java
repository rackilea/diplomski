public List<Provider> get() {
    List<Provider> providers = new ArrayList<>();
    CompletableFuture<List<Provider>> providersResponse = getSomeData();
    providersResponse.thenAccept(providers::addAll);
    return providers;
}