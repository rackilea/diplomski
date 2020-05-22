static class A {
    private int i = 0;

    public A() {
    }

    public A(int i) {
        this.i = i;
    }

    public int getI() {
        return this.i;
    }
}

static class B extends A {
    private int i;

    public B(int i) {
        this.i = i;
    }

    @Override
    public int getI() {
        return this.i;
    }
}
public static void main(String[] args) {
    B b = new B(5);

    System.out.println(b.getI());
}