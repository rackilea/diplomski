public class Outer {
    private int value = 10;

    public static class StaticInner {

    }

    public class Inner {
        public void foo() {
            System.out.println(value);
        }
    }

    public Inner createInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        StaticInner staticInner = new StaticInner();
        Inner inner = outer.new Inner();
        Inner inner2 = outer.createInner();
    }
}