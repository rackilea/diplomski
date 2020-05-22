import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class Text {

    public static void main(String[] args) {
        new Text();
    }

    public Text() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            JTextField field = new JTextField(10);
            ((AbstractDocument)field.getDocument()).setDocumentFilter(new IntegerDocumentFilter());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(field, gbc);

            InputMap im = field.getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = field.getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.SHIFT_DOWN_MASK), "Pressed.+");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), "Pressed.+");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "Pressed.-");

            am.put("Pressed.+", new DeltaAction(field, 1));
            am.put("Pressed.-", new DeltaAction(field, -1));

            add(new JButton("Test"), gbc);
        }

        protected class DeltaAction extends AbstractAction {

            private JTextField field;
            private int delta;

            public DeltaAction(JTextField field, int delta) {
                this.field = field;
                this.delta = delta;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = field.getText();
                if (text == null || text.isEmpty()) {
                    text = "0";
                }
                try {
                    int value = Integer.parseInt(text);
                    value += delta;
                    field.setText(Integer.toString(value));
                } catch (NumberFormatException exp) {
                    System.err.println("Can not convert " + text + " to an int");
                }
            }
        }

        public class IntegerDocumentFilter extends DocumentFilter {

            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                try {
                    StringBuilder sb = new StringBuilder();
                    Document document = fb.getDocument();
                    sb.append(document.getText(0, offset));
                    sb.append(text);
                    sb.append(document.getText(offset, document.getLength()));

                    Integer.parseInt(sb.toString());
                    super.insertString(fb, offset, text, attr);
                } catch (NumberFormatException exp) {
                    System.err.println("Can not insert " + text + " into document");
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
                if (length > 0) {
                    fb.remove(offset, length);
                }
                insertString(fb, offset, string, attr);
            }
        }

    }

}