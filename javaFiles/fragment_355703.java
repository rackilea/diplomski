List<Point> findPossibleMoves(int x, int y) {
    List<Point> pointList = new ArrayList<Point>();
    int length = grid.length;
    int height = grid[0].length;

    pointList.add(new Point(x - Math.min(x, y), y - Math.min(x, y)));
    pointList.add(new Point(x + Math.min(length - x, y), y - Math.min(length - x, y)));
    pointList.add(new Point(x - Math.min(x, height - y), y + Math.min(x, height - y)));
    pointList.add(new Point(x + Math.min(length - x, height - y), y + Math.min(length - x, height - y)));

    return pointList;
}