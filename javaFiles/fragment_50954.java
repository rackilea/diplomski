class B extends A {
    private ImmutablePoint p;

    private B(int x, int y) {
        super(x, y);
        this.p = new ImmutablePoint(this.getX(), this.getY());
    }

    public B(int x, int y) {
        this(x, y);
        System.err.println("Hello from B");
    }

    public B(int x, int y, String msg) {
        this(x, y);
        System.out.println(msg);
    }

    public Point getP() {
        return this.p;
    }
}