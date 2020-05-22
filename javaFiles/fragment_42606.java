JButton j1=new JButton("a");
j1.setLayout(null);
j1.setBackground(Color.red);
JButton j2=new JButton("b");
j2.setBackground(Color.yellow);
j2.setBounds(100, 100, 50, 50);
j1.add(j2);
add(j1);