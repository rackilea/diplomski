setLayout( new BorderLayout() ):

JLabel center = new JLabel("CENTER");
center.setHorizontalAlignment(JLabel.CENTER); // maybe you are missing this
add(center, BorderLayout.CENTER);

JLabel right = new JLabel("RIGHT");
add(right, BorderLayout.LINE_END);