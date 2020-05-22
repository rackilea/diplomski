static Task wrap(Runnable runnable) {
    return (f, e) -> f.thenRunAsync(runnable, e);
}
static Task sync(Task... tasks) {
    return (f, e) -> {
        for (Task task : tasks) {
            f = task.execute(f, e);
        }
        return f;
    };
}
static Task async(Task... tasks) {
    return (f, e) -> tasks.length == 0 ? f :
        CompletableFuture.allOf(
        Arrays.stream(tasks)
        .map(t -> t.execute(f, e))
        .toArray(CompletableFuture[]::new));
}