public class HystrixHook extends HystrixCommandExecutionHook {

    private HystrixRequestVariableDefault<ConcurrentHashMap<String, Object>> hrv = new HystrixRequestVariableDefault<>();

    @Override
    public <T> void onStart(HystrixInvokable<T> commandInstance) {
        HystrixRequestContext.initializeContext();
        getThreadLocals();
    }

    @Override
    public <T> void onExecutionStart(HystrixInvokable<T> commandInstance) {
        setThreadLocals();
    }


    @Override
    public <T> void onFallbackStart(HystrixInvokable<T> commandInstance) {
        setThreadLocals();
    }


    @Override
    public <T> void onSuccess(HystrixInvokable<T> commandInstance) {
        HystrixRequestContext.getContextForCurrentThread().shutdown();
        super.onSuccess(commandInstance);
    }

    @Override
    public <T> Exception onError(HystrixInvokable<T> commandInstance, HystrixRuntimeException.FailureType failureType, Exception e) {
        HystrixRequestContext.getContextForCurrentThread().shutdown();
        return super.onError(commandInstance, failureType, e);
    }

    private void getThreadLocals() {
        hrv.set(ThreadLocalUtil.getThreadLocalData());
    }

    private void setThreadLocals() {
        ThreadLocalUtil.setThreadLocalData(hrv.get());
    }
}