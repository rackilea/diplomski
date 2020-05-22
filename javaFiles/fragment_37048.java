import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;

public class MainClass {

    private char[] password;
    private String pin;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                System.out.println("Before Window");
                Window w = new Window();
                System.out.println("After Window");
                System.out.println(w.getPin() + Arrays.toString(w.getPassword()) + '1');
            }
        });
    }

    public static class Window extends JDialog {

        private JTextField textField_1;
        private JButton btnNewButton;
        private JPanel panel;
        private JPasswordField passwordField;
        private char[] password = new char[10];
        private String pin;

        public Window() {

            this.setModal(true);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setLocationRelativeTo(null);
            this.setSize(370, 150);
            this.setForeground(new Color(192, 192, 192));
            this.setTitle("Access Password Manager");
            this.setResizable(false);

            panel = new JPanel();
            getContentPane().add(panel, BorderLayout.CENTER);
            panel.setLayout(new MigLayout("", "[70.00][132.00,grow][44.00][67.00,grow][61.00][]", "[19.00][34.00][]"));

            JLabel lblNewLabel = new JLabel("Password");
            panel.add(lblNewLabel, "cell 0 1,alignx trailing,aligny center");

            passwordField = new JPasswordField();
            passwordField.setColumns(13);
            panel.add(passwordField, "cell 1 1,alignx center");

            JLabel lblNewLabel_1 = new JLabel("Key");
            panel.add(lblNewLabel_1, "cell 2 1,alignx center,aligny center");

            textField_1 = new JTextField();
            panel.add(textField_1, "cell 3 1,alignx left,aligny center");
            textField_1.setColumns(4);

            btnNewButton = new JButton("Log In");
            ListenForButton listener = new ListenForButton();

            btnNewButton.addActionListener(listener);
            panel.add(btnNewButton, "cell 4 1");

            this.setVisible(true);

        }

        private class ListenForButton implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == btnNewButton) {

                    if (passwordField.getPassword().length < 10) {

                        password = passwordField.getPassword().clone();
                    }

                    pin = textField_1.getText();

                }
            }
        }

        public char[] getPassword() {
            return password;
        }

        public String getPin() {
            return pin;
        }

    }
}