public void go(){
    JFrame frame = new JFrame("Wav Player");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JButton play = new JButton("Test");
    frame.setSize(500, 500);
    frame.add(play);
    frame.setVisible(true);
}

public static void main(String [] args)
{
    Main player = new Main();
    player.go();
}