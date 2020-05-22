JDateChooser dateChooser = new JDateChooser();
dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (manualDate) {
            return;
        }
        Date newDate = (Date) evt.getNewValue();
        Date oldDate = (Date) evt.getOldValue();
        if (newDate != null && oldDate != null) {
            LocalDate newLD = LocalDate.ofInstant(newDate.toInstant(), ZoneId.systemDefault());
            LocalDate oldLD = LocalDate.ofInstant(oldDate.toInstant(), ZoneId.systemDefault());
            if (newLD.equals(oldLD)) {
                return;
            }
        }
        System.out.println(evt.getPropertyName());
    }
});