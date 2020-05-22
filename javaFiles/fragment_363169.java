public class FieldValidationHandler implements DocumentListener() {

    private List<JTextField> monitorFields;

    public FieldValidationHandler(JTextField... fields) {
        monitorFields = Arrays.asList(fields);
        for (JTextField field : monitorFields) {
            field.getDocument().addDocumentListener(this);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        change();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        change();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        change();
    }

    private void change(){

        boolean enabled = true;
        for (JTextField field : monitorFields) {
            if (field.getText().trim().isEmpty()) {
                enabled = false;
                break;
            }
        }
        SaveButton.setEnabled(enabled);
    }
}