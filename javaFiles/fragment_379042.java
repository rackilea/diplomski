public class Obstacle {
    public static final int DEFAULT_TOP_HEIGHT = 175;
    public static final int DEFAULT_BOTTOM_HEIGHT = 175;
    public static final int DEFAULT_WIDTH = 30;
    public static final int DEFAULT_ARCH_WIDTH = 20;
    public static final int DEFAULT_ARCH_HEIGHT = 20;
    public static final int DEFAULT_TOP_INSET = -5;
    public static final int DEFAULT_BOTTOM_INSET = TheGame.HEIGHT + 5;

    private RoundRectangle2D top, bottom;
    private BasicStroke stroke;
    private GradientPaint gradient;
    private int initialX, x, width;

    public Obstacle(int x, int width, int topHeight, int bottomHeight) {
        this.x = initialX = x;
        this.width = width;

        top = new RoundRectangle2D.Double(x, DEFAULT_TOP_INSET, width, topHeight, DEFAULT_ARCH_WIDTH, DEFAULT_ARCH_HEIGHT);
        bottom = new RoundRectangle2D.Double(x, DEFAULT_BOTTOM_INSET-bottomHeight, width, bottomHeight, DEFAULT_ARCH_WIDTH, DEFAULT_ARCH_HEIGHT);

        stroke = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 20.0f, new float[] { 10.0f }, 0.0f);
        gradient = new GradientPaint(20, 0, Color.DARK_GRAY, 0, 10, Color.GRAY, true);
    }

    public Obstacle(int x, int topHeight, int bottomHeight) {
        this(x, DEFAULT_WIDTH, topHeight, bottomHeight);
    }

    public void reset() {
        x = initialX;
        top.setRoundRect(initialX, top.getY(), top.getWidth(), top.getHeight(), top.getArcWidth(), top.getArcHeight());
        bottom.setRoundRect(initialX, bottom.getY(), bottom.getWidth(), bottom.getHeight(), bottom.getArcWidth(), bottom.getArcHeight());
    }

    public Obstacle(int x, int width) {
        this(x, width, DEFAULT_TOP_HEIGHT, DEFAULT_BOTTOM_HEIGHT);
    }

    public Obstacle(int x) {
        this(x, DEFAULT_WIDTH);
    }

    public void moveToBack() {
        x = 600;
    }

    public void moveForward() {
        x -= 5;
        top.setRoundRect(x, top.getY(), top.getWidth(), top.getHeight(), top.getArcWidth(), top.getArcHeight());
        bottom.setRoundRect(x, bottom.getY(), bottom.getWidth(), bottom.getHeight(), bottom.getArcWidth(), bottom.getArcHeight());
    }

    public RoundRectangle2D getTop() {
        return top;
    }

    public RoundRectangle2D getBottom() {
        return bottom;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public void paint(Graphics2D g) {
        g.setPaint(gradient);
        g.setStroke(stroke);
        g.fill(top);
        g.fill(bottom);
    }
}