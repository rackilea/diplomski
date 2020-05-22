JFrame frame = new JFrame("Arrow Button Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.add(new BasicArrowButton(BasicArrowButton.EAST), BorderLayout.EAST);
    frame.add(new BasicArrowButton(BasicArrowButton.NORTH), BorderLayout.NORTH);
    frame.add(new BasicArrowButton(BasicArrowButton.SOUTH), BorderLayout.SOUTH);
    frame.add(new BasicArrowButton(BasicArrowButton.WEST), BorderLayout.WEST);
    frame.pack();
    frame.setVisible(true);