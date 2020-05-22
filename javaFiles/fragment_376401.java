public void initializeMenuBar(){
    //Create menu Bar
    menuBar = new JMenuBar();

    menu = new JMenu("MENU");
    menuBar.add(menu);

    newGame = new JMenuItem();
    menu.add(newGame);

    this = menuBar;

}