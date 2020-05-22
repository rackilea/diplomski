public TestFrame(){
    JPanel p1 = new JPanel();
    p1.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.insets = new Insets(5, 5, 5, 5);
    c.anchor = GridBagConstraints.WEST;
    c.gridx = 0;
    c.gridy = 0;
    p1.add(new JLabel("用户名："),c);

    c.gridy = 1;
    p1.add(new JLabel("密码："),c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 1;
    c.gridy = 0;
    c.gridx = 1;
    p1.add(userName,c);

    c.gridy = 1;
    p1.add(password,c);
    JPanel p2 = new JPanel();
    p2.add(b1);
    p2.add(b2);
    add(p1,BorderLayout.CENTER);
    add(p2,BorderLayout.SOUTH);
    b1.addActionListener(new ButtonListener());
    b2.addActionListener(new ButtonListener());
}