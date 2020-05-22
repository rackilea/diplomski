JPanel usersInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
usersInput.add(textField);
usersInput.add(okButton);

frame = new JFrame();
frame.setJMenuBar(menuBar);
frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
frame.getContentPane().add(usersInput, BorderLayout.SOUTH);
frame.setTitle("Choose your own adventure");
frame.pack();
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // It's better practice DISPOSE_ON_CLOSE ;)
frame.setVisible(true);