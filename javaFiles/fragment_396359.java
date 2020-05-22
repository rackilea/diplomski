String labels[] = {"Won", "Draw", "Lost"};
JLabel label;
for (int i =0; i<labels.length; i++) {
    label = new JLabel(labels[i]);
    label.setBounds(5, 10 + (i * 45), 50, 16);
    mainframe.add(label);
}

JTextField jTextField;
int txtFieldCount = 3;
for (int i=0 ;i<txtFieldCount; i++) {
   jTextField = new JTextField();
   jTextField.setBounds(168, 4 + (i * 45), 134, 28);
   mainframe.add(jTextField);
   jTextField.setColumns(10);
}