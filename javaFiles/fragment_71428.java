import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {

 public static JFrame frame = new JFrame("Bus Tour Booking System");

    public static void main(String[] args) {

        frame.setSize(300, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Bus Tour Booking System");
        titleLabel.setBounds(70,15,150,25);
        panel.add(titleLabel);

        JLabel userLabel = new JLabel("Username: ");
        userLabel.setBounds(30, 50, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(120, 50, 130, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(30, 80, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(120, 80, 130, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(100, 125, 80, 25);
        panel.add(loginButton);

        ActionListener myButtonListener = new MyButtonListener();
        loginButton.addActionListener(myButtonListener);

    }

    private static class MyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           SomeFrame newFrame = new SomeFrame();
           newFrame.setVisible(true);
           frame.setVisible(false);
        }

      }
 }