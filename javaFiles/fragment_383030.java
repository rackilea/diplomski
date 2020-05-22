private final class ServiceHandler extends Handler {
    //TODO whatever type of list you need
    private List<mRunnable> _runningThreads = new LinkedList<mRunnable>();

    public ServiceHandler(Looper looper) {
        super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
        mRunnable runnable = new mRunnable();
        new Thread(runnable).start();
    }
}