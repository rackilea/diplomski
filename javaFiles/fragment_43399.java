protected double angleBetween(Point2D from, Point2D to) {
    double x = from.getX();
    double y = from.getY();

    // This is the difference between the anchor point
    // and the mouse.  Its important that this is done
    // within the local coordinate space of the component,
    // this means either the MouseMotionListener needs to
    // be registered to the component itself (preferably)
    // or the mouse coordinates need to be converted into
    // local coordinate space
    double deltaX = to.getX() - x;
    double deltaY = to.getY() - y;

    // Calculate the angle...
    // This is our "0" or start angle..
    double rotation = -Math.atan2(deltaX, deltaY);
    rotation = Math.toRadians(Math.toDegrees(rotation) + 180);

    return rotation;
}