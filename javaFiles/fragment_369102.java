public int distanceTo(Point that) throws ArithmeticException {
    int distanceX = Math.subtractExact(this.x, that.x);
    int distanceY = Math.subtractExact(this.y, that.y);
    return (int) Math.sqrt(Math.addExact(Math.multiplyExact(distanceX, distanceX),
                                         Math.multiplyExact(distanceY, distanceY)));
}