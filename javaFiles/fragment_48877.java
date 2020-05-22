public class ManagedDocumentHandler implements DocumentListener {

    private JTextField toBe;
    private JTextField orNotToBe;

    public ManagedDocumentHandler(JTextField toBe, JTextField orNotToBe) {
        this.toBe = toBe;
        this.orNotToBe = orNotToBe;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateState();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateState();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateState();
    }

    protected void updateState() {
        toBe.setEnabled(true);
        orNotToBe.setEnabled(toBe.getText().trim().length() == 0);
    }

}