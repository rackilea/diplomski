Counter counter = new Counter();

JTextField t = new JTextField(40);
t.setText("Button Clicked " + 0 + " times");

JButton b1 = new JButton("Increment");
b1.addActionListener(new Incrementer(counter, t));

JButton b2 = new JButton("Reset");
b2.addActionListener(new Reset(counter, t));