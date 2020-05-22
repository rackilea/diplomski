List<Point> findPossibleMoves(int x, int y) {
    List<Point> pointList = new ArrayList<Point>();
    int length = grid.length;
    int height = grid[0].length;

    int to00 = Math.min(x, y);
    int toL0 = Math.min(length - x, y);
    int to0H = Math.min(x, height - y);
    int toLH = Math.min(length - x, height - y);
    pointList.add(new Point(x - to00, y - to00));
    pointList.add(new Point(x + toL0, y - toL0));
    pointList.add(new Point(x - to0H, y + to0H));
    pointList.add(new Point(x + toLH, y + toLH));

    return pointList;
}