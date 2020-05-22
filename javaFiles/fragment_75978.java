public HangmanGUI() {

    this.setSize(600,400);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Play Hangman");

    JPanel thePanel = new JPanel();
    button1 = new JButton("Get Answer");
    thePanel.add(button1);

    // This is very important ;)        
    add(thePanel);

    this.setVisible(true);

}