public class Outer {
    class InnerBase {
        Outer innerBaseOuter() { return Outer.this; }
    }

    class Inner1 extends InnerBase {
        public Inner1() {}
        public Inner1(Outer parentOuter) {
            parentOuter.super(); // set a different super in InnerBase
        }
        Outer innerOuter() { return Outer.this; }
    }

    public static void main(String[] args) {
        Outer outer1 = new Outer();
        Outer outer2 = new Outer();

        Inner1 a = outer1.new Inner1();
        System.out.println("Checking (a.base == a.inner) => "+
            (a.innerBaseOuter() == a.innerOuter()));

        Inner1 b = outer1.new Inner1(outer2);
        System.out.println("Checking (b.base == b.inner) => "+
            (b.innerBaseOuter() == b.innerOuter()));
    }
}