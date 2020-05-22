worker.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("paused".equals(evt.getPropertyName())) {
           System.out.println("Old status: " + evt.getOldValue());
           System.out.println("New status: " + evt.getNewValue());
        }
    }
});