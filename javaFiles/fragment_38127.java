public class JFrameTest {
    public static void main(String[] args) {
        JFrame loginFrame = new JFrame("Login");

        loginFrame.setSize(500,400);
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(0,2));

        JLabel header = new JLabel("Login");
        JLabel header2 = new JLabel("blahvlah");
        JLabel loginLabel = new JLabel("Login");
        JTextField loginField = new JTextField(24);
        JLabel passLabel = new JLabel("Password");
        JTextField passField = new JTextField(24);

        loginPanel.add(header);
        loginPanel.add(header2);
        loginPanel.add(loginLabel);
        loginPanel.add(loginField);
        loginPanel.add(passLabel);
        loginPanel.add(passField);

        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}