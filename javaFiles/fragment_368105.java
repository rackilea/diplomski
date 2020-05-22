JPanel innerPanel = new JPanel(new GridBagLayout());

JLabel userNameLabel = new JLabel("User Name:");
userNameLabel.setForeground(Color.LIGHT_GRAY);
innerPanel.add(userNameLabel, createGbc(0, 0)); // add w/ GBC
innerPanel.add(tfUsername, createGbc(1, 0)); // etc...
JLabel passwordLabel = new JLabel("Password:");
passwordLabel.setForeground(Color.LIGHT_GRAY);
innerPanel.add(passwordLabel, createGbc(0, 1));
innerPanel.add(tfPassword, createGbc(1, 1));