Box box = Box.createVerticalBox();
box.add(new JLabel("Game"));
box.add(Box.createVerticalStrut(20));
box.add(new JLabel("Button 1"));
box.add(new JLabel("Button 2"));

JFrame frame = new JFrame();
frame.add(box);
frame.pack();
frame.setVisible(true);