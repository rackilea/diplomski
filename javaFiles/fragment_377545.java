import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class DocumentFilterExample {

    public static void main(String[] args) {
        new DocumentFilterExample();
    }

    public DocumentFilterExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTextField field = new JTextField(10);
                ((AbstractDocument)field.getDocument()).setDocumentFilter(new DecimalDocumentFilter());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(field);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class DecimalDocumentFilter extends DocumentFilter {

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int offset,
                String text, AttributeSet attr)
                throws BadLocationException {

            Document doc = fb.getDocument();
            boolean hasDot = doc.getText(0, doc.getLength()).contains(".");
            StringBuilder buffer = new StringBuilder(text);
            for (int i = buffer.length() - 1; i >= 0; i--) {
                char ch = buffer.charAt(i);
                if (!Character.isDigit(ch)) {
                    if ((ch == '.' && !hasDot)) {
                        hasDot = true;
                    } else {
                        buffer.deleteCharAt(i);
                    }
                }
            }
            super.insertString(fb, offset, buffer.toString(), attr);
        }

        @Override
        public void replace(DocumentFilter.FilterBypass fb,
                int offset, int length, String string, AttributeSet attr) throws BadLocationException {
            if (length > 0) {
                fb.remove(offset, length);
            }
            insertString(fb, offset, string, attr);
        }
    }

}