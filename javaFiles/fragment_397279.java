static class A {
    public void x() {
        System.out.println("A.x");
        y();
    }
    public void y() {
        System.out.println("A.y");
    }
}

static class B extends A{
    public void y() {
        System.out.println("B.y");
    }
}


public static void main(String[] args) {
    A b = new B();
    b.x();
}