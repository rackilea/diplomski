public class Demo {

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0, 1);
        Point p4 = new Point(1, 1);

        Triangle t1 = new Triangle(p1, p2, p3);
        Triangle t2 = new Triangle(p2, p3, p4);

        t1.move(1, 1);
        t2.move(1, 1);
    }
}