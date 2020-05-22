public abstract class MySync implements Runnable {
    @Override
    public final void run() {
        try {
            preExecute();
            executeInBackground();
        } finally {
            postExecute();
        }
    }
    protected abstract void preExecute();

    protected abstract void executeInBackground();

    protected abstract void postExecute();
}