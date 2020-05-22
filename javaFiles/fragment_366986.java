public String main() {
    CompletableFuture future = null;
    try {
        // Code before that could throw Exceptions

        future = CompletableFuture.runAsync(() -> {...});

        // Code after that could throw Exceptions
    } catch (SomeException e) {
        if (future != null) future.cancel(true);
        // ...
    } catch (CompletionException e) {
        // ...
    }
}