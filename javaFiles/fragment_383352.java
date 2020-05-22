List<Point> originalPoints;
List<Point> pointsToDraw;
...
@Override
protected void paintComponent(Grapchics g) {
    super.paintComponent(g);
    for (Point point : pointsToDraw) {
        g.fillOval(point.x - 5, point.y - 5, 10, 10);
    }
}