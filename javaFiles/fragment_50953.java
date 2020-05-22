// Reconstituted version of the bytecode for our B above
class B extends A {
    private ImmutablePoint p;

    public B(int x, int y) {
        super(x, y);
        this.p = new ImmutablePoint(this.getX(), this.getY()); // <== Inserted
        System.err.println("Hello from B");
    }

    public B(int x, int y, String msg) {
        super(x, y);
        this.p = new ImmutablePoint(this.getX(), this.getY()); // <== Inserted
        System.out.println(msg);
    }

    public Point getP() {
        return this.p;
    }
}