/* TextPane 'a' **/
txtpnA = new JTextPane();
txtpnA.setBounds(47, 88, 89, 20);
contentPane.add(txtpnA);
txtpnA.setBorder(BorderFactory.createLineBorder(Color.black));

JButton btnA = new JButton(new ButtonHandler(textpnA, "a"));
btnA.setBackground(Color.YELLOW);
btnA.setBounds(47, 54, 89, 23);
contentPane.add(btnA);