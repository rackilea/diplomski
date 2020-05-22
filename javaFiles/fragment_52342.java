import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TestButtonTextField {
    public TestButtonTextField() {
        JFrame frame = new JFrame();
        frame.add(new TextFieldButton("Hello"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected class TextFieldButton extends JButton {

        private static final String FIELD = "field";
        private static final String LABEL = "label";

        private final CardLayout layout = new CardLayout();
        private final JLabel label;

        public TextFieldButton(String text) {
            super();
            setLayout(layout);

            label = new JLabel(text);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(label, LABEL);

            final JTextField field = createField();
            this.add(field, FIELD);

            this.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    layout.show(TextFieldButton.this, FIELD);
                    TextFieldButton.this.setEnabled(false);
                }
            });

        }

        private JTextField createField() {
            final JTextField field = new JTextField(5);
            field.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    label.setText(field.getText());
                    field.setText("");
                    layout.show(TextFieldButton.this, LABEL);
                    TextFieldButton.this.setEnabled(true);
                }
            });
            return field;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TestButtonTextField();
            }
        });
    }
}