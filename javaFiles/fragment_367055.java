public MainMenuPanel(){
    // A new panel
    panel = new JPanel();

    //For testing //TODO remove
    panel.setBackground(Color.BLACK);

    newGameButton = new JButton("New Game");
    quitButton = new JButton("Quit");

    //New Game -button
    newGameButton.setPreferredSize(new Dimension(200, 100));
    newGameButton.setFont(menuFont);

    //Quit-button
    quitButton.setPreferredSize(new Dimension(200, 100));
    quitButton.setFont(menuFont);

    panel.setLayout(menuLayout);
    c1.insets = new Insets(10, 10, 10, 10);
    c1.gridx = 0;
    c1.gridy = 1;
    panel.add(newGameButton, c1);
    c1.gridx = 0;
    c1.gridy = 2;
    panel.add(quitButton, c1);
    // But what do you do with panel??
}