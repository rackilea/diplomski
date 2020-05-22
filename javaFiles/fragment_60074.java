public class LoadMasterPropertyChanegHandler implements PropertyChangeListener {

    private SwingWorkerExample example;

    public LoadMasterPropertyChanegHandler(SwingWorkerExample example) {
        this.example = example;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getPropertyName());
        if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
            int value = (int) evt.getNewValue();
            example.showProgress(value);
        } else if ("state".equalsIgnoreCase(evt.getPropertyName())) {
            SwingWorker worker = (SwingWorker) evt.getSource();
            if (worker.isDone()) {
                try {
                    worker.get();
                    example.loadCompleted();
                } catch (InterruptedException | ExecutionException exp) {
                    example.loadFailed();
                }
            }
        }
    }

}