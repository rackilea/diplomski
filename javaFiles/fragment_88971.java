public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        super("Test Frame");
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        JLabel userNameLabel = new JLabel("User Name");
        JLabel passwordLabel = new JLabel("Password");

        JTextField userNameTextField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        JButton configureButton = new JButton("Configure");

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;

        c.weightx = 0.0;
        add(userNameLabel, c);

        c.gridy++;
        add(passwordLabel, c);

        c.weightx = 1.0;
        c.gridx++;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        add(userNameTextField, c);

        c.gridy++;
        add(passwordField, c);

        c.gridy++;
        add(configureButton, c);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}