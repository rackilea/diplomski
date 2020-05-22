exitButton = new JButton("Exit");
exHandler = new ExitButtonHandler();
exitButton.addActionListener(exHandler);

mainMenuButton = new JButton("Main Menu");
mmHandler = new MainMenuButtonHandler();
mmHandler.setExitButton(exitButton) // newly added
mainMenuButton.addActionListener(mmHandler);