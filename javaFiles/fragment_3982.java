public class Ball {

    private int x;
    private int y;

    private int deltaX;
    private int deltaY;

    private int dimeter;

    private Ellipse2D ball;
    private Color color;

    public Ball(Color color, Dimension bounds) {
        this.color = color;
        Random rnd = new Random();

        dimeter = 5 + rnd.nextInt(15);

        x = rnd.nextInt(bounds.width - dimeter);
        y = rnd.nextInt(bounds.height - dimeter);

        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }

        int maxSpeed = 10;
        do {
            deltaX = rnd.nextInt(maxSpeed) - (maxSpeed / 2);
        } while (deltaX == 0);

        do {
            deltaY = rnd.nextInt(maxSpeed) - (maxSpeed / 2);
        } while (deltaY == 0);

        ball = new Ellipse2D.Float(0, 0, dimeter, dimeter);

    }

    public void update(Dimension bounds) {

        x += deltaX;
        y += deltaY;

        if (x < 0) {
            x = 0;
            deltaX *= -1;
        } else if (x + dimeter > bounds.width) {
            x = bounds.width - dimeter;
            deltaX *= -1;
        }
        if (y < 0) {
            y = 0;
            deltaY *= -1;
        } else if (y + dimeter > bounds.height) {
            y = bounds.height - dimeter;
            deltaY *= -1;
        }

    }

    public void paint(Graphics2D g2d) {

        g2d.translate(x, y);
        g2d.setColor(color);
        g2d.fill(ball);
        g2d.translate(-x, -y);

    }

}