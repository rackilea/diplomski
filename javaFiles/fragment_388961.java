// Instantiate a FocusListener ONCE
java.awt.event.FocusListener myFocusListener = new java.awt.event.FocusListener() {
    public void focusGained(java.awt.event.FocusEvent focusEvent) {
        try {
            JTextField src = (JTextField)focusEvent.getSource();
            if (src.getText().equals("Text here!") {
                src.setText("");
            }
        } catch (ClassCastException ignored) {
            /* I only listen to JTextFields */
        }
    }

    public void focusLost(java.awt.event.FocusEvent focusEvent) {
        try {
            JTextField src = (JTextField)focusEvent.getSource();
            if (src.getText().equals("") {
                src.setText("Text here!");
            }
        } catch (ClassCastException ignored) {
            /* I only listen to JTextFields */
        }
    }
};