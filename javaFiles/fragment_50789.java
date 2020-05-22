class Slice {

    double value;
    Color color;

    public Slice(double value, Color color) {

        this.value = value;
        this.color = color;
    }

    public Color getColor() {

        return color;
    }

    public double getValue() {

        return value;
    }
}

class PieChart extends JPanel {

    private final int SIZE = 500, START = 40, START_DEG = 90;
    private final int TRIG_HBASE = 66, TRIG_HEIGHT = 36;
    private final int x0 =(START + SIZE / 2), y0 = START;
    private final Polygon poly;

    private Color a = Color.RED;
    private Color b = Color.BLUE;
    private Color c = Color.YELLOW;
    Slice[] slices = {new Slice(65, a), new Slice(123, b), new Slice(212, c)};

    PieChart() {

        setBackground(Color.WHITE);

        int x1 = x0 + TRIG_HBASE,  y1 = y0;
        int x2 = x0 - TRIG_HBASE,  y2 = y0;
        int x3 = x0,               y3 = y0 - TRIG_HEIGHT;
        poly = new Polygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(START, START, SIZE, SIZE);

        double total = 0d;
        for (Slice slice : slices) {
            total += slice.getValue();
        }

        double startAngle = START_DEG;
        double arcAngle, centerAngle;
        double x, y;

        for (Slice slice : slices) {
            arcAngle = (slice.getValue() * 360 / total);
            g2d.setColor(slice.getColor());
            g2d.fill(new Arc2D.Double(START, START, SIZE, SIZE, startAngle, arcAngle, Arc2D.PIE));

            centerAngle = Math.toRadians(((startAngle - START_DEG) + arcAngle / 2));
            x = (START + SIZE / 2 * (1 - Math.sin(centerAngle)));
            y = (START + SIZE / 2 * (1 - Math.cos(centerAngle)));

            AffineTransform trans = AffineTransform.getTranslateInstance(x - x0, y - y0);
            AffineTransform rot = AffineTransform.getRotateInstance(-centerAngle, x, y);
            Shape s = trans.createTransformedShape(poly);
            s = rot.createTransformedShape(s);

            g2d.setColor(slice.getColor().darker());
            g2d.fill(s);

            startAngle += arcAngle;
        }
    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(START * 2 + SIZE, START * 2 + SIZE);
    }
}