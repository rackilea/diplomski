Point getLineEnd(Point lineStart, Point touchPoint, int length) {
    double rad = Math.atan((touchPoint.y - lineStart.y) / (touchPoint.x - lineStart.x));
    Point lineEnd = new Point(lineStart);
    lineEnd.offset(length * Math.cos(rad), length * Math.sin(rad));
    return lineEnd;
}