JDateChooser aDateChooserInstance = new JDateChooser();

// Listen for property changes
aDateChooserInstance.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        // If the 'date' property was changed...
        if ("date".equals(evt.getPropertyName())) {
            JDateChooser aDateChooser = (JDateChooser) evt.getSource();
            boolean isDateSelectedByUser = false;
            // Get the otherwise unaccessible JDateChooser's 'dateSelected' field.
            try {
                // Get the desired field using reflection
                Field dateSelectedField = JDateChooser.class.getDeclaredField("dateSelected");
                // This line makes the value accesible (can be read and/or modified)
                dateSelectedField.setAccessible(true);
                isDateSelectedByUser = dateSelectedField.getBoolean(aDateChooser);
            } catch (Exception ignoreOrNot) {
            }

            // Do some important stuff depending on wether value was changed by user
            if (isDateSelectedByUser) {
                importantStuff();
            }

            // Reset the value to false
            try {
                Field dateSelectedField = JDateChooser.class.getDeclaredField("dateSelected");
                dateSelectedField.setAccessible(true);
                isDateSelectedByUser = dateSelectedField.setBoolean(aDateChooser, false);
            } catch (Exception ignoreOrNot) {
            }
        }
    }
});