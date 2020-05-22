abstract class A {

    A() {
        init();
    }

    protected abstract void init();
}

class B extends A {

    public String x = null;
    public String y;

    @Override
    protected void init() {
        x = "x";
        y = "y";
    }
}

public static void main(String[] args) {
    B b = new B();
    System.out.printf("x=%s, y=%s%n", b.x, b.y);
}