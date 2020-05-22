public class B {

  public double g(IFunction funct, double[] b, double[] c, double[] d) {
    funct.eval(b, c, d);
    return d[0];
  }

  public static void main(String[] args) {
     A a = new A(1);
     double[] b = {2};
     double[] c = {3};
     double[] d = {4};

     double res = g(a::f, b,c, d);
 }