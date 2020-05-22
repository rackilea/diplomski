package pkg2;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class TestProgram extends JPanel {
    private JTextField textField = new JTextField(20);
    private JSpinner exitCodeSpinner = new JSpinner(new SpinnerNumberModel(0, -10, 10, 1));

    public TestProgram() {        
        SendTextAction sendTextAxn = new SendTextAction();
        textField.setAction(sendTextAxn);

        JPanel panel1 = new JPanel();
        panel1.add(textField);
        panel1.add(new JButton(sendTextAxn));

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Exit Code:"));
        panel2.add(exitCodeSpinner);
        panel2.add(new JButton(new ExitCodeAction()));
        panel2.add(new JButton(new ThrowExceptionAction()));

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(panel1);
        add(panel2);
    }

    private static abstract class MyAction extends AbstractAction {
        public MyAction(String name, int mnemonic) {
            super(name);
            putValue(MNEMONIC_KEY, mnemonic);
        }

    }

    private class SendTextAction extends MyAction {
        public SendTextAction() {
            super("Send Text", KeyEvent.VK_S);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textField.getText();
            textField.setText("");
            System.out.println(text);
        }
    }

    private class ExitCodeAction extends MyAction {
        public ExitCodeAction() {
            super("Exit Code", KeyEvent.VK_X);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int exitCode = (int) exitCodeSpinner.getValue();
            System.exit(exitCode);
        }
    }

    private class ThrowExceptionAction extends MyAction {
        public ThrowExceptionAction() {
            super("Throw Exception", KeyEvent.VK_T);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // throw some unchecked exception
            throw new NumberFormatException("Unchecked exception thrown from within TestProgram");
        }
    }

    private static void createAndShowGui() {
        TestProgram mainPanel = new TestProgram();

        JFrame frame = new JFrame("Test Program");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}