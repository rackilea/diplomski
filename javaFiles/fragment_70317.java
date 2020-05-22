public class Triangle {
    Point a;
    Point b;
    Point c;

    public Triangle(final Point a, final Point b, final Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.printf("Created triangle %s with points (%s, %s, %s)%n", this, this.a, this.b, this.c);
    }

    void move(int dx, int dy) {
        System.out.printf("Moving triangle %s (%s,%s)%n", this, dx, dy);
        a.move(dx, dy);
        b.move(dx, dy);
        c.move(dx, dy);
    }
}