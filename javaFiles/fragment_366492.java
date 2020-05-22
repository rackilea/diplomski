JPanel top = new JPanel();
top.setBorder(new LineBorder(Color.RED));
JPanel bottom = new JPanel();
bottom .setBorder(new LineBorder(Color.BLUE));

JPanel parent = new JPanel(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.weighty = 0.7;
gbc.fill = GridBagConstraints.BOTH;
parent.add(top, gbc);

gbc.gridy++;
gbc.weighty = 0.3;
parent.add(bottom, gbc);