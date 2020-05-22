// Reconstituted version of the bytecode for our B above
class B extends A {
    private ImmutablePoint p;

    public B(int x, int y) {
        super(x, y);
        this.p = new ImmutablePoint(this.getX(), this.getY()); // <== Inserted
        System.out.println("Hello from B");
    }

    public Point getP() {
        return this.p;
    }
}