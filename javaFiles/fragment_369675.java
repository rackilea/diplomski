JPanel ctrPanel = new JPanel(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridwidth = GridBagConstraints.REMAINDER;
ctrPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

gbc.fill = GridBagConstraints.HORIZONTAL;
ctrPanel.add(jComboBox, gbc);
ctrPanel.add(Box.createRigidArea(new Dimension(50, 15)), gbc);
gbc.fill = GridBagConstraints.NONE;
ctrPanel.add(fmtButton, gbc);