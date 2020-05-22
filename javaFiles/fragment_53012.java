sayHello(new Continuation<String>() {
    @Override
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override
    public void resume(String value) {
        doSomethingWithResult(value);
    }

    @Override
    public void resumeWithException(@NotNull Throwable throwable) {
        doSomethingWithError(throwable);
    }
});