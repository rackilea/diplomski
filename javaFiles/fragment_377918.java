JFrame frame = new JFrame();
JPanel panel = new JPanel(new BorderLayout());
JFileChooser chooser = new JFileChooser();
panel.add(chooser);
frame.add(panel);
frame.pack();
frame.setVisible(true);