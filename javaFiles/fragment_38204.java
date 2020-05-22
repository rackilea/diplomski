public class Example extends JPanel {

    final static int GRID_SIZE = 4;
    final static int CELL_SIZE = 150;
    final static int CIRCLE_RAD = 20;
    final static int HALF_CIRCLE_WIDTH = 4;

    final static Color BACKGROUND = Color.WHITE;
    final static Color CIRCLE_FILL = new Color(185, 42, 42);
    final static Color CIRCLE_EDGE = Color.BLACK;
    final static Color LINK_FILL = Color.BLUE;
    final static Color NOLINK_FILL = new Color(150, 75, 0);

    final static BasicStroke LINK_STROKE = new BasicStroke(10);
    final static BasicStroke NOLINK_STROKE = new BasicStroke(2);
    final static BasicStroke CIRCLE_STROKE = new BasicStroke(HALF_CIRCLE_WIDTH);


    boolean[][][] links = new boolean[GRID_SIZE][GRID_SIZE][2];

    Example() {

        setBackground(BACKGROUND);

        Random rand = new Random();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                links[i][j][0] = rand.nextBoolean(); // isLinkingtoRight
                links[i][j][1] = rand.nextBoolean(); // isLinkingtoDown
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {

        int dim = CIRCLE_RAD * 2 + CELL_SIZE * (GRID_SIZE - 1) + HALF_CIRCLE_WIDTH * 2;
        return new Dimension(dim, dim);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {

                if (j != GRID_SIZE - 1) {
                    if (links[i][j][0]) {
                        g2d.setColor(LINK_FILL);
                        g2d.setStroke(LINK_STROKE);
                    }
                    else {
                        g2d.setColor(NOLINK_FILL);
                        g2d.setStroke(NOLINK_STROKE);
                    }
                    g2d.drawLine(i * CELL_SIZE + CIRCLE_RAD + HALF_CIRCLE_WIDTH, j * CELL_SIZE  + CIRCLE_RAD + HALF_CIRCLE_WIDTH,
                                 i * CELL_SIZE + CIRCLE_RAD + HALF_CIRCLE_WIDTH, (j + 1) * CELL_SIZE + CIRCLE_RAD + HALF_CIRCLE_WIDTH);
                }
                if (i != GRID_SIZE - 1) {
                    if (links[i][j][1]) {
                        g2d.setColor(LINK_FILL);
                        g2d.setStroke(LINK_STROKE);
                    }
                    else {
                        g2d.setColor(NOLINK_FILL);
                        g2d.setStroke(NOLINK_STROKE);
                    }
                    g2d.drawLine(i * CELL_SIZE + CIRCLE_RAD + HALF_CIRCLE_WIDTH, j * CELL_SIZE + CIRCLE_RAD + HALF_CIRCLE_WIDTH,
                                 (i + 1) * CELL_SIZE + CIRCLE_RAD + HALF_CIRCLE_WIDTH, j * CELL_SIZE + CIRCLE_RAD + HALF_CIRCLE_WIDTH);
                }
            }
        }

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(CIRCLE_STROKE);
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                g2d.setColor(CIRCLE_FILL);
                g2d.fillOval(i * CELL_SIZE + HALF_CIRCLE_WIDTH, j * CELL_SIZE + HALF_CIRCLE_WIDTH, CIRCLE_RAD * 2, CIRCLE_RAD * 2);
                g2d.setColor(CIRCLE_EDGE);
                g2d.drawOval(i * CELL_SIZE + HALF_CIRCLE_WIDTH, j * CELL_SIZE + HALF_CIRCLE_WIDTH, CIRCLE_RAD * 2, CIRCLE_RAD * 2);
            }
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.add(new Example());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}