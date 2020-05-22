JFrame frame = new JFrame("FrameDemo");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel emptyLabel = new JLabel("");
emptyLabel.setPreferredSize(new Dimension(175, 100));
frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

//Display the window.
frame.pack();
frame.setVisible(true);