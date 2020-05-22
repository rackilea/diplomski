model.clear();
scan.setEnabled(false);
ScanWorker worker = new ScanWorker(new File("..."), model);
worker.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equalsIgnoreCase(evt.getPropertyName())) {
            SwingWorker.StateValue state = (SwingWorker.StateValue) evt.getNewValue();
            scan.setEnabled(state == SwingWorker.StateValue.DONE);
            scan.setText("Scan");
        } else if ("directory".equalsIgnoreCase(evt.getPropertyName())) {

            scan.setText(text);

        }
    }
});
worker.execute();