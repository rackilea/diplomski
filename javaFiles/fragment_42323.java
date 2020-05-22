private static class HttpWorker extends SwingWorker<Void, Void> {
    private final String url;
    private HttpWorker(String url) {
        this.url = Objects.requireNonNull(url);
    }
    @Override
    protected Void doInBackground() {
        // do request, possibly producing some result
    }
    @Override
    protected void done() {
        if (!isCancelled()) {
            // update UI
        }
    }
}

private HttpWorker worker;

@Override
public void valueChanged(ListSelectionEvent e) {
    if (worker != null) {
        // preserve apparent order of operations if
        // the user selects something different while
        // a background task is already running
        worker.cancel(true);
        worker = null;
    }
    worker = new HttpWorker(...);
    worker.execute();
}