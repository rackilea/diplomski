JFrame frame = new JFrame();
//...
frame.setContentPane(backgroundLabel);
frame.setLayout(new GridBagLayout());

ImageIcon title = new ImageIcon("title.png");
JLabel titleLabel = new JLabel(title);
frame.add(titleLabel);
//...