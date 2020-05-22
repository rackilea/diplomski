public class Ball {
    public static final int DEFAULT_DROP_SPEED = 7;

    private Ellipse2D ball;
    private GradientPaint gradient;
    private int initialY, x, y, width = 30, height = 30, dropSpeed = DEFAULT_DROP_SPEED;

    public Ball(int x, int y) {
        this.x = x;
        this.y = initialY = y;
        width = height = 30;

        ball = new Ellipse2D.Double(x, y, width, height);
        gradient = new GradientPaint(30, 0, Color.BLACK, 0, 20, Color.GREEN, true);
    }

    public void reset() {
        y = initialY;
        updateBall();
    }

    public void jump() {
        dropSpeed = DEFAULT_DROP_SPEED;
        y -= 40;
        updateBall();
    }

    public void fall() {
        y += dropSpeed++;
        updateBall();
    }

    private void updateBall() {
        ball.setFrame(x, y, width, height);
    }



    public boolean intersects(double x, double y, double w, double h) {
        return ball.intersects(x, y, w, h);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return width;
    }

    public void paint(Graphics2D g) {
        g.setPaint(gradient);
        g.fill(ball);
    }

    public void moveForward() {
        x += 7;
    }
}