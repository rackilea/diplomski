GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    add(textbox("Total"), gbc);
    add(textbox("Tip %"), gbc);
    add(textbox("People"), gbc);