public class Example {

    interface I { }
    static class A { int x = 1;}
    static class B extends A implements I { int y = 2;}
    static class C extends B { }
    static class D extends B{ }
    static class E implements I { }

    public static final void main(String[] args) {
        C c2 = new C();
        doTheCheck(c2);
    }

    static void doTheCheck(Object o) {
        System.out.println(o instanceof D);
    }
}