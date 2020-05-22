public GameViewPanel(){

    // Create JPanel...
    JPanel gameViewPanel = new JPanel();

    gameViewPanel.setLayout(bordL);
    gameViewPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); 

    //Creating toolbar
    JToolBar toolbar = new JToolBar();
    toolbar.setFloatable(false);

    gameViewPanel.setLayout(bordL);
    gameViewPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); 
    gameViewPanel.add(toolbar, BorderLayout.PAGE_START);        

    //Buttons
    lopetaButton = new JButton("Lopeta");
    menuButton = new JButton("Päävalikko");
    tallennaButton = new JButton("Tallenna");

    //Adding buttons to game view toolbar
    toolbar.add(lopetaButton); //TODO Add functionality!
    toolbar.add(tallennaButton); //TODO Add functionality!
    toolbar.add(menuButton); //TODO Add functionality!
    // But never do anything with it...
}