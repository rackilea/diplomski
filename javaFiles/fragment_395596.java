public class LabelBackground {

    public static void main(String[] args) {
        new LabelBackground();
    }

    public LabelBackground() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new LoginPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class LoginPane extends JLabel {

        public LoginPane() {
            try {
                setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/background.jpg"))));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.EAST;
            gbc.insets = new Insets(2, 2, 2, 2);
            gbc.gridx = 0;
            gbc.gridy = 0;

            JLabel nameLabel = new JLabel("Name: ");
            nameLabel.setForeground(Color.WHITE);
            JLabel passwordLabel = new JLabel("Password: ");
            passwordLabel.setForeground(Color.WHITE);

            add(nameLabel, gbc);
            gbc.gridy++;
            add(passwordLabel, gbc);

            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx++;
            gbc.gridy = 0;
            add(new JTextField(20), gbc);
            gbc.gridy++;
            add(new JTextField(20), gbc);

            gbc.gridy++;
            gbc.insets = new Insets(10, 2, 2, 2);
            gbc.anchor = GridBagConstraints.EAST;
            add(new JButton("Submit"), gbc);

        }

    }

}