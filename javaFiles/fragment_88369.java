JFrame screen = new JFrame("Dungeon of Doom");
screen.setLayout(new GridLayout(2, 0));
screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//set size to full screen. 
screen.setExtendedState(Frame.MAXIMIZED_BOTH);   

//Add all JPanes to screen
screen.getContentPane().add(lookReplyGUI());
screen.getContentPane().add(titlePanel());

// Do this only when you're ready
screen.setVisible(true);