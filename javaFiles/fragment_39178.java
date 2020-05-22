public static void main(String[] args) {
    Background b = new Background();
    Dimension d = new Dimension(900, 885); //Create a new Dimension
    b.setTitle("Game");
    b.setPreferredSize(d);  //Set the PreferredSize;
    b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    b.pack();  //Pack the frame
    b.setVisible(true);  //Setting Visible
}