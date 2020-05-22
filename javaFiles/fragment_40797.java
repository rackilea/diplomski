public static void main(String[] args) {
    GamePanel panel = new GamePanel(); //Call your init methods to initialize the panel only, not the jframe
    //Initialize the key listener object either implemented in the game panel itself, or initialized inside of the panel
    new Thread(panel).start(); 
    JFrame frame = new JFrame("im actually not that bad at coding");
    frame.setLocation(0, 0);
    frame.add(panel);
    frame.addKeyListener(panel.getKeyListener()); //Or addListener, i am doing this not on an IDE
    frame.setDefaultCloseOperation(JFrame.BLOW_UP_SYSTEM_ON_EXIT);
    //Optional, just click the frame: frame.setFocus(true);
    frame.pack();
    frame.setVisible(true);
}