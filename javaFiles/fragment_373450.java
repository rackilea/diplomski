public class Integrals 
{

    public interface Function {
        double eval(double x);
    }

    public static final Function f1 = new Function() {
      public double eval(double x) {
        return x*5+Math.sin(x);
      }
    };

    public static final Function f2 = new Function() {
      public double eval(double x) {
        return Math.pow(x*f1.eval(-x),x);
      }
    };

    public static double TrapezoidalIntegration(double a,double b,int n,Function f)
    {
        // … using f.eval(x) to compute values