JCalendar jc = new JCalendar();
jc.addPropertyChangeListener("calendar", new PropertyChangeListener() {

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        final Calendar c = (Calendar) e.getNewValue();   
        System.out.println(c.get(Calendar.DAY_OF_MONTH));   
    }
});