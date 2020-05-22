public class GameFrame extends JFrame {

    private double stepLen;

    public GameFrame() {
        this.stepLen = 50;

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Frogger");
        // Well, there's your problem...
        //this.setLayout(null);
        // Don't do this here...
        this.setVisible(true);

        this.getContentPane().setBackground(Color.black);

        // Simpler way to achieve this
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //int x = (dim.width - this.getSize().width) / 2;
        //int y = (dim.height - this.getSize().height) / 2;

        GameCanvas gcanvas = new GameCanvas();
        this.add(gcanvas);
        this.pack();

        //this.setLocation(x, y);

        setLocationRelativeTo(null);
        setVisible(true);

    }

}