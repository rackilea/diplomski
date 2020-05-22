JPanel timeInputPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
timeInputPanel.add(text_33);
timeInputPanel.add(label_4);
timeInputPanel.add(text_4);
timeInputPanel.add(upDownPanel);

c.fill = GridBagConstraints.BOTH;
c.weightx = 1.0;
c.weighty = 1.0;
c.gridx = 0;
c.gridy = 15;
c.insets = new Insets(0, 10, 0, 0);
panel_4.add(timeInputPanel, c);