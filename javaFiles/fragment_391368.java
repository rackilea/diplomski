gbc.gridy = line;
gbc.gridx = column;
gbc.gridheight = 1;
gbc.gridwidth = 1;
gbc.anchor = GridBagConstraints.WEST;
gbc.insets = new Insets(1, 5, 3, 5);

// ***** add these two lines
gbc.weightx = 1.0;
gbc.weighty = 1.0;