static class MyFutureTask<T> extends FutureTask<T> {
    final Callable<T> theCallable;

    public MyFutureTask(Callable<T> callable) {
        super(callable);
        theCallable=callable;
    }
}