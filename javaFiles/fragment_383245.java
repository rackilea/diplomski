Future<DataResponse> wrapper = new Future<DataResponse>() {
    private final Future<DataResponse> delegate = future;

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return delegate.cancel(mayInterruptIfRunning);
    }

    @Override
    public boolean isCancelled() {
        return delegate.isCancelled();
    }

    @Override
    public boolean isDone() {
        return delegate.isDone();
    }

    @Override
    public DataResponse get() throws InterruptedException, ExecutionException {
        DataResponse dataResponse = null;
        try {
            delegate.get();
        } catch (TimeoutException ex) {
            PotoLogging.logErrors(ex, DataErrorEnum.TIMEOUT_ON_CLIENT, dataKey);
            dataResponse = new DataResponse(null, DataErrorEnum.TIMEOUT_ON_CLIENT, DataStatusEnum.ERROR);
        }
        return dataResponse;
    }

    @Override
    public DataResponse get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        DataResponse dataResponse = null;
        try {
            delegate.get(timeout, unit);
        } catch (TimeoutException ex) {
            PotoLogging.logErrors(ex, DataErrorEnum.TIMEOUT_ON_CLIENT, dataKey);
            dataResponse = new DataResponse(null, DataErrorEnum.TIMEOUT_ON_CLIENT, DataStatusEnum.ERROR);
        }
        return dataResponse;
    }
};
return wrapper;