JPanel top = new JPanel(new GridLayout(1,1))
JPanel left = new JPanel();
JPanel right = new JPanel();
top.add(left);
top.add(right);
JFrame frame = new JFrame();
frame.add(top);
frame.setSize(400,400);
frame.setVisible(true);