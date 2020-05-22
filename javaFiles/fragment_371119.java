public Point[] sortedPoints(final int x, final int y) {
    Point[] sorted = Arrays.copyOf(MOVES, MOVES.length);
    Arrays.sort(sorted, new Comparator<Point>() {
        public int compare(Point p1, Point p2) {
            return Integer.signum(nextMoves(p1) - nextMoves(p2));
        };
        private int nextMoves(Point p) {
            Point dst = new Point(x + p.x, y + p.y);
            if (canMove(dst)) {
                int s = 0;
                for (Point m : MOVES) {
                    Point dst2 = new Point(dst.x + m.x, dst.y + m.y);
                    if (canMove(dst2)) {
                        s++;
                    }
                }
                return s;
            } else {
                return 999;
            }
        }
    });
    return sorted;
}