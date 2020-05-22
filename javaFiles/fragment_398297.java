public class Outer {

    int x;

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        outer.x = 3;
        inner.x = 2;
        inner.f(1);
    }

    class Inner extends Outer {
        int x;

        void f(int x) {
            System.out.println(super.x);
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(Outer.this.x);
        }
    }

}