buttonPanel = new JPanel(new GridBagLayout());
//...
add(buttonPanel, BorderLayout.SOUTH);

GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.insets = new Insets(100, 0, 0, 0);

buttonPanel.add(btn1, gbc);

gbc.insets = new Insets(0, 0, 0, 0);
gbc.gridx++;
gbc.gridy++;
buttonPanel.add(btn2, gbc);