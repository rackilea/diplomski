JFrame frame = new JFrame();
ImageIcon icon = new ImageIcon("image.jpg");
JLabel label = new JLabel(icon);
frame.add(label);
frame.setDefaultCloseOperation
     (JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setVisible(true);