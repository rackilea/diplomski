public class TraficLight01 extends JPanel {

    public static final int RADIUS = 20;

    private Timer timer;
    private int state = 0;

    public TraficLight01() {
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state++;
                if (state > 2) {
                    state = 0;
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(RADIUS, (RADIUS + 1) * 3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        int radius = 20;
        Ellipse2D light = new Ellipse2D.Float(0, 0, RADIUS, RADIUS);
        int x = (getWidth() - radius) / 2;
        int y = ((getHeight()- (radius * 3)) / 2) + (radius * 2);

        Color color[] = new Color[]{Color.RED, Color.YELLOW, Color.GREEN};
        for (int index = 0; index < color.length; index++) {
            g2d.translate(x, y);
            g2d.setColor(color[index]);
            g2d.draw(light);
            if (state == index) {
                g2d.fill(light);
            }
            g2d.translate(-x, -y);
            y -= radius + 1;
        }
        g2d.dispose();
    }        
}