JTextField fooField = new JTextField(15);
  JTextField barField = new JTextField(15);
  JPanel moreComplexPanel = new JPanel(new GridBagLayout());
  GridBagConstraints gbc = new GridBagConstraints();
  gbc.insets = new Insets(5, 5, 5, 5);
  gbc.weightx = 1.0;
  gbc.weighty = 1.0;
  gbc.anchor = GridBagConstraints.WEST;
  moreComplexPanel.add(new JLabel("Foo:"), gbc);
  gbc.gridx = 1;
  gbc.anchor = GridBagConstraints.EAST;
  moreComplexPanel.add(fooField, gbc);
  gbc.gridx = 0;
  gbc.gridy = 1;
  gbc.anchor = GridBagConstraints.WEST;
  moreComplexPanel.add(new JLabel("Bar:"), gbc);
  gbc.gridx = 1;
  gbc.anchor = GridBagConstraints.EAST;
  moreComplexPanel.add(barField, gbc);

  int result = JOptionPane.showConfirmDialog(myGui, moreComplexPanel, 
        "Foobars Forever", JOptionPane.OK_CANCEL_OPTION, 
        JOptionPane.PLAIN_MESSAGE);
  if (result == JOptionPane.OK_OPTION) {
     System.out.println("foo = " + fooField.getText());;
     System.out.println("bar = " + barField.getText());;
  }