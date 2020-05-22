public static ArrayList<Line> sumAll(ArrayList<Line> lines) {
        ArrayList<Point> points = getAllPoints(lines);
        ArrayList<Line> result = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++)
        {
            Point current = points.get(i);
            Point next = points.get(i + 1);
            ArrayList<Line> filtered = filter(current, lines);
            Line acc = new Line(new Point(current.getX(), 0), new Point(
                    next.getX(), 0));

            for (Line lf : filtered)
            {
                acc = acc.sum(lf, current, next);
            }

            result.add(acc);
        }
        return result;
    }