public class BackspaceAction extends AbstractAction {

    private JTextField field;

    public BackspaceAction(JTextField field) {
        putValue(NAME, "Back-space");
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Document doc = field.getDocument();
        if (doc.getLength() > 0) {
            int position = field.getCaretPosition();
            if (position > 0) {
                try {
                    doc.remove(position - 1, 1);
                    field.setCaretPosition(Math.max(position - 1, 0));
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}