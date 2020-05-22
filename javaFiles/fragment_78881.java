import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TestOptionPane extends JPanel {
    private static final Color FOREGROUND = Color.RED;
    private static final Color PRESSED_FG = Color.BLUE;
    private JButton button1 = new JButton(new Button1Action());
    private JButton button2 = new JButton(new Button1Action());

    public TestOptionPane() {
        setPreferredSize(new Dimension(600, 450));
        button1.getModel().addChangeListener(new ButtonModelListener(button1));
        button1.setForeground(FOREGROUND);
        add(button1);
        button2.getModel().addChangeListener(new ButtonModelListener(button2));
        button2.setForeground(FOREGROUND);
        add(button2);
    }

    private class Button1Action extends AbstractAction {
        public Button1Action() {
            super("Queue JOptionPane on Swing event thread");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(TestOptionPane.this, "hello");
            });
        }
    }

    private class Button2Action extends AbstractAction {
        public Button2Action() {
            super("Show non-modal JOptionPane");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(() -> {
                Component parentComponent = TestOptionPane.this;
                JOptionPane optionPane = new JOptionPane("Hello", JOptionPane.PLAIN_MESSAGE);
                JDialog dialog = optionPane.createDialog(parentComponent, "Fubars Rule!");
                dialog.setModalityType(ModalityType.MODELESS);
                dialog.setLocationRelativeTo(parentComponent);
                dialog.setVisible(true);
            });
        }
    }

    private class ButtonModelListener implements ChangeListener {
        private JButton button;

        public ButtonModelListener(JButton button) {
            this.button = button;
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isPressed()) {
                button.setForeground(PRESSED_FG);
            } else {
                button.setForeground(FOREGROUND);
            }
        }

    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("TestOptionPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TestOptionPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}