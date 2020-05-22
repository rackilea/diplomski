JPanel leftTop = new JPanel(new GridBagLayout());
//leftTop.setPreferredSize(new Dimension(266, 300));
leftTop.setBackground(Color.black);

JScrollPane scrollPane = new JScrollPane(leftTop); //problem is here
left.add(scrollPane);

GridBagConstraints gbc = new GridBagConstraints();
gbc.gridwidth = GridBagConstraints.REMAINDER;
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.weightx = 1;
gbc.insets = new Insets(5, 10, 5, 10);
JButton jb = new JButton();
jb.setPreferredSize(new Dimension(250, 50));
leftTop.add(jb, gbc);

JButton jb1 = new JButton();
jb1.setPreferredSize(new Dimension(250, 50));
leftTop.add(jb1, gbc);

JButton jb2 = new JButton();
jb2.setPreferredSize(new Dimension(250, 50));
leftTop.add(jb2, gbc);

JButton jb3 = new JButton();
jb3.setPreferredSize(new Dimension(250, 50));
leftTop.add(jb3, gbc);

JButton jb4 = new JButton();
jb4.setPreferredSize(new Dimension(250, 50));
leftTop.add(jb4, gbc);

JButton jb5 = new JButton();
jb5.setPreferredSize(new Dimension(250, 50));
leftTop.add(jb5, gbc);

JButton jb6 = new JButton();
jb6.setPreferredSize(new Dimension(250, 50));
leftTop.add(jb6, gbc);