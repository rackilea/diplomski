setLayout(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridwidth = GridBagConstraints.REMAINDER;
gbc.anchor = GridBagConstraints.WEST;
add(new JLabel("Happy as can be"), gbc);
add(new JTextField(10), gbc);
add(new JLabel("Happy place"), gbc);
// etc..