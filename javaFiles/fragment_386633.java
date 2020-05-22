frame.add(main);
frame.setLayout(new BorderLayout());
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(addButton, BorderLayout.EAST);
frame.add(saveButton, BorderLayout.WEST);
frame.pack();
frame.setSize(500, 300); 
frame.setVisible(true);