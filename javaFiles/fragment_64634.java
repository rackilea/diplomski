public static ArrayList<Point> getAllPoints(ArrayList<Line> lines) {
        HashSet<Point> points = new HashSet<Point>();
        for (Line line : lines)
        {
            points.add(line.getP1());
            points.add(line.getP2());
        }
        ArrayList<Point> res = new ArrayList<Point>(points);
        Collections.sort(res);
        return res;
    }