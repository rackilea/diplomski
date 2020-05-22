JFrame frame = new JFrame("GUI");
Numbers numbers = new Numbers();
frame.setLayout(new BorderLayout());
frame.add(new JLabel("Phone numbers: "), BorderLayout.NORTH);
frame.add(numbers,BorderLayout.CENTER);
frame.pack();
frame.setVisible(true);