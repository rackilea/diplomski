JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
frame.setLocation(400, 100);
frame.setTitle("hello world");

ImageIcon img = new ImageIcon(test.class.getResource("image.png"));
JPanel panel = new JPanel();
JLabel label = new JLabel(img);
panel.add(label);
panel.setVisible(true);

frame.add(panel);
frame.pack();