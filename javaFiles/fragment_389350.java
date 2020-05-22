CompletableFuture.allOf(
        CompletableFuture.runAsync(new FutureTask<Void>(() -> foo(), null)),
        CompletableFuture.runAsync(new FutureTask<Void>(() -> bar(), null))
)
.exceptionally(t -> {
    throw new UndeclaredThrowableException(t);
})
.get();