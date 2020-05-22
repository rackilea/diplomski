MyWorker worker = new MyWorker();
worker.addPropertyChangeListener(new PropertyChangeListener() {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress".equals(evt.getPropertyName())) {
            myProgressBar.setValue((Integer) evt.getNewValue());
        }
    }
}