private JFrame jfr;
//private JPanel jpn;

PickupBall b = new PickupBall();
//Snake bob = new Snake();

public PlayGame() {
    jfr = new JFrame("Snake");
    jfr.setSize(640, 640);
    jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //jpn = new JPanel();
    this.setBackground(Color.WHITE);

    //jfr.add(jpn);
    jfr.setContentPane(this);
    jfr.setVisible(true);
}