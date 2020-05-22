JPanel panel = new JPanel();
int gap = 20;  //or whatever
frame.getContentFrame().setLayout(new BorderLayout());
frame.add(panel, BorderLayout.CENTER);
panel.add(Box.createHorizontalStrut(gap), BorderLayout.EAST);
panel.add(Box.createHorizontalStrut(gap), BorderLayout.WEST);
panel.add(Box.createVerticalStrut(gap), BorderLayout.NORTH);
panel.add(Box.createVerticalStrut(gap), BorderLayout.SOUTH);