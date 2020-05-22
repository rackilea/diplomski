class Point {
    final int x;
    final int y;
    Point(int x, int y) { this.x = x; this.y = y; }
}

class Line {
    final int slope;
    final int intercept;
    Line(Point p1, Point p2) {
        this.slope = ...;
        this.intercept = ...;
    }
}

class Points {
    public void doIt(ArrayList<Point> points) {
        ArrayList<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                lines.add(new Line(points.get(i), points.get(j));
            }
        }
        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
                Line line1 = lines.get(i);
                Line line2 = lines.get(j);
                if (line1.slope == line2.slope && line1.intercept == line2.intercept) {
                    // blah blah blah
                }
            }
        }
    }
}