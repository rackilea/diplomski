@Override
public PointQuery point(Node node) {
    Point2D topLeftPoint = node.localToScreen(0, 0);
    Point2D pos = new Point2D(topLeftPoint.getX(), topLeftPoint.getY());

    return super.point(node).atOffset(pos);
}