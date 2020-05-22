class A {
    void f(double x ) { 
        System.out.print ("A.f(double=" + x + ") "); 
    }
}
class C extends A {
    void f(double q ) {
        System.out.print ("C.f(long=" + q + ") ");
    }
}
public class PolySur {
    public static void main (String args [ ]) {
        double x = 0;
        A a = new C();
        a.f(x);
    }
}