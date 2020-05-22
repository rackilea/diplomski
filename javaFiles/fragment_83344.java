public static boolean findPoints(Area area1, Line2D line1, int depth) {

    Point p1 = new Point((int) (line1.getX2() + line1.getX1()) / 2,
            (int) (line1.getY2() + line1.getY1()) / 2);

    if (depth == 0) {
        return false;
    }

    pointMiddle = new Point(p1);
    if (area1.contains(p1)) {
        return true;

    } else {
        return findPoints(area1, new Line2D.Double(p1, line1.getP2()),
                depth - 1)
                || findPoints(area1, new Line2D.Double(line1.getP1(), p1),
                        depth - 1);
    }

}