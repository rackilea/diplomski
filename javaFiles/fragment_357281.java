public class BackspaceAction extends AbstractAction {

    private JTextField field;

    public BackspaceAction(JTextField field) {
        putValue(NAME, "Back-space");
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = field.getText();
        if (!text.isEmpty()) {
            int position = field.getCaretPosition();
            if (position > 0) {
                text = text.substring(0, position - 1) + text.substring(position);
                field.setText(text);
                field.setCaretPosition(Math.max(position - 1, 0));
            }
        }
    }

}