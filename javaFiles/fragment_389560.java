float angle=getAngle(pointDestination);
x += speed * Math.cos(angle);
y += speed * Math.sin(angle);

public double getAngle(Point target) {
    return Math.atan2(target.y - y, target.x - x);
}