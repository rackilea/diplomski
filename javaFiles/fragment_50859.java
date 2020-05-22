JDayChooser jdc = new JDayChooser();
jdc.addPropertyChangeListener("day", new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        System.out.println(e.getPropertyName()+ ": " + e.getNewValue());
    }
});