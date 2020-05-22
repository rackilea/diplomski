class A { 
    int x;
    int y;

    public A(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
class B extends A {
    private ImmutablePoint p = new ImmutablePoint(this.getX(), this.getY());

    public B(int x, int y) {
        super(x, y);
        System.out.println("Hello from B");
    }

    public Point getP() {
        return this.p;
    }
}