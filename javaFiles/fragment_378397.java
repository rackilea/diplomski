// FutureTask = Runnable (for run) + Future<Void> (for cancel(boolean))
class MyTask extends FutureTask<Void> {
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) { ... }

    @Override
    public void run() { ... }
}