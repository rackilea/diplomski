public class A {
    private int x;

    public A(int x) {
        if (x < 0) throw new IllegalArgumentException("x cannot be negative");
        this.x = x;
    }
}

public class B extends A {
    private String y;

    public B(int x, String y) {
        super(x);
        if (y == null) throw new IllegalArgumentException("y cannot be null");
        this.y = y;
    }
}