import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.GapContent;
import javax.swing.text.PlainDocument;

public class FillJPasswordField extends JFrame {

    private JPasswordField pass;

    public FillJPasswordField() {
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        char[] password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};

        MyGapContent content = new MyGapContent();
        PlainDocument doc = new PlainDocument(content);
        try {
            content.insertChars(0, password);
        } catch (BadLocationException ex) {
        }
        pass = new JPasswordField(20);
        pass.setDocument(doc);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.weightx = 1.0d;
        gbc.insets = new Insets(10, 5, 10, 5);
        add(pass, gbc);

        System.out.println(new String(pass.getPassword()));

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new FillJPasswordField().setVisible(true);
            }
        });
    }

    private class MyGapContent extends GapContent {

        public MyGapContent() {
            super();
        }

        public MyGapContent(int initialLength) {
            super(initialLength);
        }

        public void insertChars(int where, char[] chars) throws BadLocationException {
            if (where > length() || where < 0) {
                throw new BadLocationException("Invalid insert", length());
            }
            replace(where, 0, chars, chars.length);
        }
    }
}