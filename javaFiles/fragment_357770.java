CompletableFuture<String> ask = CompletableFuture.supplyAsync(() -> {
    throw new IndexOutOfBoundsException();
});
CompletableFuture<String> translatedException = ask.handle((r, e) -> {
    if (e != null) {
        if (e instanceof IndexOutOfBoundsException) {
            throw new IllegalArgumentException();
        }
        throw (RuntimeException) e; // this is sketchy, handle it differently, maybe by wrapping it in a RuntimeException
    }
    return r;
});