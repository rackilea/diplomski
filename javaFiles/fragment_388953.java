JFrame frame = new JFrame();
frame.setLayout(new GridLayout());
JLabel label = new JLabel("<html>First line<br>Second line</html>");
frame.add(label);
frame.pack();
frame.setVisible(true);