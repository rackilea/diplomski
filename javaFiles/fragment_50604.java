gbc = new GridBagConstraints();
gbc.gridx = 1;
gbc.gridy = 0;
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.insets = new Insets(2, 8, 2, 4);
gbc.anchor = GridBagConstraints.NORTH;
for (int index = 0; index < 6; index++) {
    core.add(new JButton("Button #" + index), gbc);
    gbc.gridy++;
}