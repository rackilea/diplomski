abstract class Task extends SwingWorker {
    @Override
    protected abstract Void doInBackground();
    @Override
    protected abstract void done();
};