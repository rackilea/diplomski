public int distanceTo(Point that) {
    long distanceX = Math.subtractExact((long) this.x, (long) that.x);
    long distanceY = Math.subtractExact((long) this.y, (long) that.y);
    long sumOfSquares = Math.addExact(Math.multiplyExact(distanceX, distanceX),
                                      Math.multiplyExact(distanceY, distanceY));
    return Math.toIntExact((long) Math.sqrt(sumOfSquares));
}