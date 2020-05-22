JTextField field  = new JTextField(20);
JLabel label = new JLabel("Enter your text here");
JPanel p = new JPanel(new BorderLayout(5, 2));
p.add(label, BorderLayout.WEST);
p.add(field);
JOptionPane.showMessageDialog(null, p, "Name required", JOptionPane.PLAIN_MESSAGE, null);
String text = field.getText();
System.out.println("You've entered: " + text);