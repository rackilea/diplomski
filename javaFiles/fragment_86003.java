JFrame frame = new JFrame("Testing");
frame.setDefaultCloseOperation(JFrame.DIPOSE_ON_CLOSE);
frame.add(new JLabel(new ImageIcon(img)));
frame.pack();
frame.setLocationRelativeTo(this);
frame.setVisible(true);