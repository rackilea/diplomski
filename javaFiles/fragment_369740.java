JFrame frame = new JFrame("Calculator");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JPanel panel = new JPanel();
frame.add(panel);

JButton num1 = new JButton("1");
panel.add(num1);    

frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);