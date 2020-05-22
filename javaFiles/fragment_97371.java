public static class TraficLight02 extends JPanel {

    public static final int RADIUS = 20;

    private Timer timer;
    private int state = 0;

    // Green, Yellow, Red
    private int[] intervals = new int[]{3000, 500, 3000};

    public TraficLight02() {
        timer = new Timer(intervals[0], new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                state++;
                if (state > 2) {
                    state = 0;
                }
                timer.setInitialDelay(intervals[state]);
                repaint();
                timer.restart();
            }
        });
        timer.start();
        timer.setRepeats(false);
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

        Color color[] = new Color[]{Color.GREEN, Color.YELLOW, Color.RED};
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