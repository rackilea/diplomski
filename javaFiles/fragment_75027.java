public Game(){
    // Set the JFrame properties
    setTitle("Rollin' Dice");
    this.setPreferredSize(new Dimension(600,600));

    // Create the main JPanel to hold the interface
    mainPanel = new JPanel(new BorderLayout());


    // Build the Menu
    options = new JMenu("Options");

    quit = new JMenuItem("Quit");
    options.add(quit);

    explanation = new JMenuItem("Explanation");
    options.add(explanation);

    menuBar = new JMenuBar();
    menuBar.add(options);

    // Add the menu to the top of the main panel
    mainPanel.add(menuBar,BorderLayout.NORTH);


    // Create the dice
    dr = new DiceRoll();
    diceLabel = new JLabel();
    diceLabel2 = new JLabel();

    dicePanel = new JPanel(new GridLayout(2,1));
    dicePanel.add(diceLabel);
    dicePanel.add(diceLabel2);

    // Add the dicePanel to the center of the main panel
    mainPanel.add(dicePanel,BorderLayout.CENTER);


    // Add the rollDice button to the bottom of the main panel
    rollDice = new JButton("Roll Dice");
    mainPanel.add(rollDice,BorderLayout.SOUTH);


    // Add listeners to the menu items and buttons
    quit.addActionListener(this);
    explanation.addActionListener(this);
    rollDice.addActionListener(this);

    // Add the main panel to the JFrame
    this.getContentPane().add(mainPanel);

    // Show the JFrame
    this.pack();
    this.setVisible(true);
}