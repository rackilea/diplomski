public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint circleCenter;

    public MovableCircle (int x, int y, int xSpeed, int ySpeed, int radius) {
        this.radius = radius;
        this.circleCenter = new MovablePoint(x, y, xSpeed, ySpeed);
    }