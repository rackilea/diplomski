public class MainClass {

    public static void main(String[] args) {

    Game game = new Game();

    JFrame frame = new JFrame();

    frame.addKeyListener(new AL());
    frame.setTitle("Game");
    frame.setSize(500, 500);
    frame.setResizable(true);
    frame.getContentPane().add(game);
    frame.setBackground(Color.BLACK);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    Thread t = new Thread(game);
    t.start();

    }


    }