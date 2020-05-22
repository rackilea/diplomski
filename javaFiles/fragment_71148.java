JTextField text=new JTextField();
text.setText("this is textfield");
text.setBounds(20,0,100,20);
JPanel panel=new JPanel();
panel.addLayout(new FlowLayout());
panel.setBackground(Color.blue);
panel.add(text);