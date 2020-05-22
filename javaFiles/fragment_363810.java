frame.getContentPane().add(jsp); // problem
frame. setSize(1000, 700);
JButton button = new JButton();
button.setSize(new Dimension(300, 300)); // does nothing
button.setLocation(500, 350); // does nothing
frame.getContentPane().add(button); //problem