public void move(Ball ball, Point mouse) {

    try {
        Point p = ball.getLocation();
        Point speed = ball.getSpeed();
        Dimension size = ball.getSize();

        int diameter = ball.dimeter;

        int vx = speed.x;
        int vy = speed.y;

        int x = p.x;
        int y = p.y;

        int radiusX = (size.width / 2);
        int radiusY = (size.height / 2);

        // ----------------------

        if (mouse != null) {
            int xDistance = Math.abs((x + (diameter / 2)) - mouse.x);
            int yDistance = Math.abs((y + (diameter / 2)) - mouse.y);

            System.out.printf("b(%d, %d) m(%d, %d) dx(%d, %d)\n", x, y,
                    mouse.x, mouse.y, (x + vx) - mouse.x, (y + vy)
                            - mouse.y);

            if (xDistance <= radiusX && yDistance <= radiusY) {

                if (xDistance < yDistance) {
                    vx *= -1;
                } else {
                    vy *= -1;
                }

                System.out.println("Hit");
            }
        }

        if (x + vx < 0 || x + size.width + vx > getParent().getWidth()) {
            vx *= -1;
        }
        if (y + vy < 0
                || y + size.height + vy > getParent().getHeight()) {
            vy *= -1;
        }

        x += vx;
        y += vy;

        ball.setSpeed(new Point(vx, vy));
        ball.setLocation(new Point(x, y));

    } catch (Exception e) {
        e.printStackTrace();
    }
}