JButton startButton = new JButton("Start");
JButton scoreButton = new JButton("High Score");
JButton instructButton = new JButton("Instructions");
JButton exitButton = new JButton("Exit");

GridBagConstraints gbc = new GridBagConstraints();
gbc.fill = java.awt.gbc.HORIZONTAL;
gbc.insets = new java.awt.Insets(2, 2, 2, 2);
gbc.gridx = 0;
gbc.gridy = 0;
getContentPane().add(startButton, gbc);

gbc.gridy = 1;
getContentPane().add(scoreButton, gbc);

gbc.gridy = 2;
getContentPane().add(instructButton, gbc);

gbc.gridy = 3;
getContentPane().add(exitButton, gbc);