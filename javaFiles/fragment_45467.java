Point startPoint = null;
for (int[] cell : path) {
    Point endPoint = new Point((cell[0] * cellSize) + cellPadding, (cell[1] * cellSize) + cellPadding);
    if (startPoint != null) {
        g2d.draw(new Line2D.Double(startPoint, endPoint));
    }
    startPoint = endPoint;
}