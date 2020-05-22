dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getPropertyName());
    }
});