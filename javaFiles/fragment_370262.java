private Point2D.Double initial = ... // The initial position
private Point2D.Double current = ... // The current position
private Point2D.Double target = ... // The target position

void applyMovment(double alpha) {
    double dx = target.getX() - initial.getX();
    double dy = target.getY() - initial.getY();
    current.x = initial.getX() + alpha * dx;
    current.y = initial.getY() + alpha * dy;
}