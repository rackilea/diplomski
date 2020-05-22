public MainFrame() {
    pieceIcon[0] = new ImageIcon(System.getProperty("user.dir") + 
        "/images/piece1.png");
    pieceIcon[1] = new ImageIcon(System.getProperty("user.dir") + 
        "/images/piece2.png");

    this.add(boardPanel);
    displayGUIboard();
}


public void displayGUIboard() {
    boardPanel.add(new JLabel(pieceIcon[0]);
    boardPanel.add(new JLabel(pieceIcon[0]);
}