public class TestPane extends JPanel {

    public TestPane() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(new JTextField(10), gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;

        add(new JButton("1"), gbc);
        gbc.gridx++;
        add(new JButton("2"), gbc);
        gbc.gridx++;
        add(new JButton("3"), gbc);

    }

}