class ProgressWorker extends Task<Void> {

    ...

    @Override
    protected Void call() throws Exception {
        while (getCurrentRow() < getMaxRow()) {
            Thread.sleep(100);
            updateProgress(getCurrentRow(), getMaxRow());
            updateMessage(getTextMessage());
        }
        return null;
    }
}