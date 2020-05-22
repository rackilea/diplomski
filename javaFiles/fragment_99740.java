JFrame frame = new JFrame("Grid Hopper");
frame.setSize(1120,800);
frame.setLayout(new FlowLayout());
JPanel pane = new JPanel();
pane.add(game);
pane.add(score);
frame.add(pane);