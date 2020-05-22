float newX = x + vx * delta;
boolean xCollision = false;
if (vx < 0) {
    int i = level.toIndex(x);
    int j = level.toIndex(y + getHeight() / 2);
    xCollision = level.isBlocked(i, j);
} else if (vx > 0) {
    int i = level.toIndex(x + getWidth());
    int j = level.toIndex(y + getHeight() / 2);
    xCollision = level.isBlocked(i, j);
}
if (!xCollision) x = newX;