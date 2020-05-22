public class A {
    private double a;

    public A(double a_) {a = a_;}

    public void f(double[] b, double[] c, double[] d) {
        d[0] = a * (b[0] + c[0]);
    }
 }