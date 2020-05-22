public class Ball extends JPanel{

    public void paint(Graphics g) {
        g.drawOval(100, 100, 50, 50);
    }

    public static void main(String[] args) {
        JFrame game = new JFrame("Ball game!");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setResizable(false);
        game.setLayout(null);
        game.setSize(300, 550);
        game.setLocation(400, 200);

        Ball d = new Ball();

        game.setContentPane(d); // <- this line
        game.setVisible(true);
    }

}