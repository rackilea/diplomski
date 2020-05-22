public class NumberAction extends AbstractAction {

    private JTextField field;
    private int number;

    public NumberAction(JTextField field, int number) {
        this.field = field;
        this.number = number;
        putValue(NAME, Integer.toString(number));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Document doc = field.getDocument();
        try {
            doc.insertString(doc.getLength(), Integer.toString(number), null);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

}