private void moveHeroBy(double dx, double dy) {
    if (dx == 0 && dy == 0) {
        return;
    }
    double x = dx + translate.getX();
    double y = dy + translate.getY();
    translate.setX(x);
    translate.setY(y);
}

public void rotate(int angle) {
    angle += rotate.getAngle();
    if (angle == 360) {
        angle = 0;
    }
    rotate.setAngle(angle);
}