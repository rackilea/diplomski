AffineTransform transform = new AffineTransform();

@Override
void update(double secondsElapsed) {
    ...
    // Clear the previous translation and rotation.
    transform.setToIdentity();
    // Set to current.
    transform.translate(locX, locY);
    Point2D.Double center = getCenter();
    transform.rotate(rotationAngle + (Math.PI / 2), center.x, center.y);

    if (controls.isFireHeld()) {
        Point2D.Double tip = new Point2D.Double(0, 0);
        transform.transform(tip, tip);
        Bullet bullet = new Bullet(tip.x, tip.y, rotationAngle);
        bullets.add(bullet);
    }
}