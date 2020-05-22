@SuppressWarnings("serial")
public class MyGame extends JFrame {

    public MyGame() {
        this.initComponent();
    }

    private void initComponent() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Game");
        this.setSize(320, 240);
        this.setLayout(null);
        this.setUndecorated(true);
        this.setResizable(false);

        JLayeredPane layered = this.getLayeredPane();
        layered.add(new Canvas(), new Integer(0));
        layered.add(new TopFrame(), new Integer(1));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame game = new MyGame();
                game.setVisible(true);
            }
        });
    }
}