import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.JTextComponent;

public class TestNumPad {

    public static void main(String[] args) {
        new TestNumPad();
    }

    public TestNumPad() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
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
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            JTextField field = new JTextField(10);
            add(field, gbc);
            add(new NumPad(), gbc);
            field.requestFocusInWindow();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public class NumPad extends JPanel {

        private ActionHandler actionHandler;

        public NumPad() {
            setLayout(new GridLayout(4, 3));
            actionHandler = new ActionHandler();
            for (int index = 1; index < 10; index++) {
                add(createButton(index));
            }
            add(new JPanel());
            add(createButton(0));
            add(new JPanel());
        }

        protected JButton createButton(int index) {
            JButton btn = new JButton(String.valueOf(index));
            btn.setFocusable(false);
            btn.addActionListener(actionHandler);
            return btn;
        }

        public class ActionHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source instanceof JButton) {
                    JButton btn = (JButton) source;
                    try {
                        int value = Integer.parseInt(btn.getText().trim());
                        Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
                        if (comp instanceof JTextComponent) {
                            JTextComponent tc = (JTextComponent) comp;
                            tc.setText(tc.getText() + value);
                        }
                    } catch (Exception exp) {
                        exp.printStackTrace();
                    }
                }
            }
        }
    }
}