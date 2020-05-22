private class DefaultExecutor implements Executor {

    @Override
    public void execute(@NonNull Runnable runnable) {
        runnable.run();
    }
}