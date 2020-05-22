public Triangle(final Point a, final Point b, final Point c) {
    this.a = new Point(a.x, a.y);
    this.b = new Point(b.x, b.y);
    this.c = new Point(c.x, c.y);
    System.out.printf("Created triangle %s with points (%s, %s, %s)%n", this, this.a, this.b, this.c);
}