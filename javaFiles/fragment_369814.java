public class Curve{

    private List<Point> points = new ArrayList<>(0);

    public Curve(List<Point> points) {
        this.points = points;
    }

    public Curve(List<Point> points, boolean flag) {
        this.points.addAll(points);
    }

    void print() {
        for(Point p : points) {
            System.out.println(p);
        }
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "X = " + x +"\nY = " + y ;
        }

    }

    public static void main(String[] args) {
        List<Curve.Point> points = new ArrayList<Curve.Point>(0);
        points.add(new Curve.Point(0,0));
        points.add(new Curve.Point(0,1));
        // Care for compiler error just one should be used
        Curve c = new Curve(points,true); // Using this constructor copies the elements and the folloing add wont affect c
        Curve c = new Curve(points); // Using this constructor uses the same list so the following add will affect c
        points.add(new Curve.Point(1,1));
        c.print();
    }
}