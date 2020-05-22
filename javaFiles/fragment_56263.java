DecimalFormat format = new DecimalFormat();
format.setParseBigDecimal(true);
JFormattedTextField ftf = new JFormattedTextField(format):
ftf.addPropertyChangeListener(new PropertyChangeListener() {

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("value"))
            if ( ((BigDecimal) evt.getNewValue()).compareTo(BigDecimal.ZERO) ==0 )
                ftf.setValue(evt.getOldValue());
        }

    });