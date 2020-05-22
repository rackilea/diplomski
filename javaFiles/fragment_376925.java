import java.awt.Graphics;
import java.awt.geom.Point2D;

public class Ball {

    private Point2D position;

    /** velocity in pixels per second */
    private double  velocity;

    /**
     * direction in radians
     * <ul>
     * <li>0 - Heading east (+x)</li>
     * <li>PI / 2 - Heading north (-y)</li>
     * <li>PI - Heading west (-x)</li>
     * <li>PI * 3 / 2 - Heading south (+y)</li>
     * </ul>
     * */
    private double  direction;

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void moveBall(long milliseconds) {
        Point2D oldPosition = position;

        // Calculate distance of ball motion
        double distance = velocity / (1000.0D * milliseconds);

        // Calculate new position
        double newX = distance * Math.cos(direction);
        double newY = distance * Math.sin(direction);

        newX = oldPosition.getX() + newX;
        newY = oldPosition.getY() - newY;

        // Update position
        position.setLocation(newX, newY);
    }

    public void draw(Graphics g) {
        int radius = 3;
        int x = (int) Math.round(position.getX());
        int y = (int) Math.round(position.getY());

        // Draw circle of radius and center point x, y
        g.drawOval(x - radius, y - radius, radius + radius, radius + radius);

    }

}