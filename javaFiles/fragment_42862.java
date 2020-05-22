PausableSwingWorker<Void, String> worker = new PausableSwingWorker<Void, String>() {
    @Override
    protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
            if (!isPaused()) {
                // proceed with background task
            } else {
                Thread.sleep(200); // Optional sleep to avoid check status continuously
            }
        }
        return null;
    }
};