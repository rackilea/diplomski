private boolean manualDate = false;
//...
dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (manualDate) {
            return;
        }
        System.out.println(evt.getPropertyName());
    }
});

manualDate = true;
dateChooser.setDate(new Date());
manualDate = false;