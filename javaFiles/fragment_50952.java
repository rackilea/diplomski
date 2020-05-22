class B extends A {
    private ImmutablePoint p = new ImmutablePoint(this.getX(), this.getY());

    public B(int x, int y) {
        super(x, y);
        System.err.println("Hello from B");
    }

    public B(int x, int y, String msg) {
        super(x, y);
        System.out.println(msg);
    }

    public Point getP() {
        return this.p;
    }
}