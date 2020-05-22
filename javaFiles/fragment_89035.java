// In the classes variable decleration section...
private JTextField rfidField;

// In the classes constructor or UI init method...
rfidField = new JTextField(12);
rfidField.getDocument().addDocumentListener(new DocumentListener() {

    public void handleUpdate(DocumentEvent e) {

        if (e.getDocument().getLength() == 10) {

            System.out.println("Trigger me happy...");
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    rfidField.setText(null);
                }
            });

        }

    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        handleUpdate(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        handleUpdate(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        handleUpdate(e);
    }
});

// Now don't forget to add the field to your forms container ;)
//////