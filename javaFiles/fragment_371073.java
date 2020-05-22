import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class DocumentFilterOnTheFlyCalculation {

    public DocumentFilterOnTheFlyCalculation() {
        createAndShowGui();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DocumentFilterOnTheFlyCalculation();
            }
        });
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        JLabel label1 = new JLabel("Add:");
        final JTextField jtf1 = new JTextField();

        JLabel label2 = new JLabel("Add:");
        final JTextField jtf2 = new JTextField();

        JLabel label3 = new JLabel("Subtract:");
        final JTextField jtf3 = new JTextField();

        JLabel totalLabel = new JLabel("Total:");
        final JTextField totalField = new JTextField("0");
        totalField.setEditable(false);

        DocumentFilter df = new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {

                if (isDigit(string)) {
                    super.insertString(fb, i, string, as);
                    calcAndSetTotal();
                }
            }

            @Override
            public void remove(FilterBypass fb, int i, int i1) throws BadLocationException {
                super.remove(fb, i, i1);
                calcAndSetTotal();
            }

            @Override
            public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
                if (isDigit(string)) {
                    super.replace(fb, i, i1, string, as);
                    calcAndSetTotal();

                }
            }

            private boolean isDigit(String string) {
                for (int n = 0; n < string.length(); n++) {
                    char c = string.charAt(n);//get a single character of the string
                    //System.out.println(c);
                    if (!Character.isDigit(c)) {//if its an alphabetic character or white space
                        return false;
                    }
                }
                return true;
            }

            void calcAndSetTotal() {
                int sum = 0;

                if (!jtf1.getText().isEmpty()) {
                    sum += Integer.parseInt(jtf1.getText());//we must add this
                }
                if (!jtf2.getText().isEmpty()) {
                    sum += Integer.parseInt(jtf2.getText());//we must add this
                }
                if (!jtf3.getText().isEmpty()) {
                    sum -= Integer.parseInt(jtf3.getText());//we must subtract this
                }

                totalField.setText(String.valueOf(sum));
            }
        };

        ((AbstractDocument) (jtf1.getDocument())).setDocumentFilter(df);
        ((AbstractDocument) (jtf2.getDocument())).setDocumentFilter(df);
        ((AbstractDocument) (jtf3.getDocument())).setDocumentFilter(df);

        frame.add(label1);
        frame.add(jtf1);
        frame.add(label2);
        frame.add(jtf2);
        frame.add(label3);
        frame.add(jtf3);
        frame.add(totalLabel);
        frame.add(totalField);

        frame.pack();
        frame.setVisible(true);
    }
}