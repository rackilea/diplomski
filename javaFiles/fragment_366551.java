public class Panel extends JPanel {

    public static final int drops = 1;
    public RainDrop[] d = new RainDrop[drops];

    public Panel() {
        for (int i = 0; i < drops; i++) {
            d[i] = new RainDrop();
        }
    }

    public void update() {
        for (int i = 0; i < drops; i++) {
            d[i].fall();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        for (int i = 0; i < drops; i++) {
            d[i].draw(g);
            repaint();
        }
    }
}