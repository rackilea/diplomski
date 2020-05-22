public class Outer {
    public class Inner {
    }
    void f() {System.out.println(new Inner());}
}
Outer x = new Outer();