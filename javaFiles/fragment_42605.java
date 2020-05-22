JButton j1=new JButton("a");
j1.setLayout(new BorderLayout());
j1.setBackground(Color.red);
add(j1);
JButton j2=new JButton("b");
j2.setBackground(Color.yellow);
j1.add("Center", j2);