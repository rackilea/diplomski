JPanel panel = new JPanel(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();

gbc.gridx = 0;
gbc.gridy = 0;
panel.add(new JButton("Roll First Time"), gbc);
gbc.gridx++;
panel.add(new JButton("Roll Again"), gbc);
gbc.gridx++;
panel.add(new JButton("Let the other player roll"), gbc);

gbc.gridx = 0;
gbc.gridy++;
// You could also use a EmptyBorder
gbc.insets = new Insets(100, 0, 0, 0);
gbc.gridwidth = 3;
panel.add(new JTextField(10), gbc);