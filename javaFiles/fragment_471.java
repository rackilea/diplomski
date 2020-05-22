setLayout(new GridBagLayout());
GridBagConstraints gc = new GridBagConstraints();

gc.gridx = 0;
gc.gridy = 0;
gc.weighty = 1;
gc.fill = GridBagConstraints.BOTH;
gc.gridheight = GridBagConstraints.REMAINDER;
add(listScroller, gc);

gc.gridx = 2;
gc.gridy = 0;
gc.weighty = 0;
gc.fill = GridBagConstraints.NONE;
gc.gridheight = 1;
add(nameLabel, gc);