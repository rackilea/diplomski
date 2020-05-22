class UploadUtilListener implements PropertyChangeListener {
    public void propertyChanged(PropertyChangeEvent e) {
        if (e.getNewValue() == SwingWorker.StateValue.DONE) {
            // do your code here that you want called when worker done
        }
    }
}