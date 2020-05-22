final JOptionPane optionPane = new JOptionPane("What is your first name?",
    JOptionPane.QUESTION_MESSAGE);
optionPane.setWantsInput(true);

Action accept = new AbstractAction("OK") {
    private static final long serialVersionUID = 1;
    public void actionPerformed(ActionEvent event) {
        Object value = optionPane.getInputValue();
        if (value != null && !value.toString().isEmpty()) {
            // This dismisses the JOptionPane dialog.
            optionPane.setValue(JOptionPane.OK_OPTION);
        }
    }
};

Object acceptButton = new JButton(accept);
optionPane.setOptions(new Object[] { acceptButton, "Cancel" });
optionPane.setInitialValue(acceptButton);

// Waits until dialog is dismissed.
optionPane.createDialog(null, "First Name").setVisible(true);

if (!Integer.valueOf(JOptionPane.OK_OPTION).equals(optionPane.getValue())) {
    // User canceled dialog.
    return;
}

String fn = optionPane.getInputValue().toString();