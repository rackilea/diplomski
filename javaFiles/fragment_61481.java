List<Callable<Void>> callables = new ArrayList<>();
for (Runnable r : runnables) {
    callables.add(toCallable(r));
}
executor.invokeAll(callables);

private Callable<Void> toCallable(final Runnable runnable) {
    return new Callable<Void>() {
        @Override
        public Void call() {
            runnable.run();
            return null;
        }
    };
}