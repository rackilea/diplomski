public class MoveFocusForwardHandler implements DocumentListener {

    private int maxLength;

    public MoveFocusForwardHandler(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        documentChanged(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        documentChanged(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        documentChanged(e);
    }

    protected void documentChanged(DocumentEvent e) {
        if (getMaxLength() > 0) {
            if (e.getDocument().getLength() >= getMaxLength()) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
            }
        }
    }

}