import java.lang.*;

interface RealFunc {
    public double eval(double x);
}

class myfunc implements RealFunc {

  int c,n;  
  double alpha;

  public myfunc(int nn, int cc, double aalpha) {
    c=cc; n=nn; alpha = aalpha;
  }

  public double eval(double p) {
    double sum = 1;
    double term = 1;
    for(int i = 1; i<=c; i++) {
        term *= (n*p)/i;
        sum += term;
     }
     return sum*Math.exp(-n*p) - alpha;
   }
}


public class SecantSolverSO34980366 {

  static public double illinois(RealFunc f, double a, double b) {
        double fa = f.eval(a);
        double fb = f.eval(b);
        while(Math.abs(b-a) > 1e-10) {
        //System.out.printf("a:f(%16.12f) = %16.12f | b: f(%16.12f) = %16.12f \n ",a,fa,b,fb);
          double c = (a*fb-b*fa)/(fb-fa);
          double fc = f.eval(c);
          if( fa*fc < 0 ) {
            fa *= 0.5;
          } else {
            a = b; fa = fb;
          }
          b = c; fb = fc;
      }
      return b;
  }


  public static void main(String[] args) {
    int n = 1;

    for(double alpha = 0.2; alpha <=1.0001; alpha += 0.1) {
        System.out.printf("alpha=%4.2f: ", alpha);
        for(int c = 2; c < 15; c+=2) {

            double p = illinois(new myfunc(n,c,alpha), 0.,(c+13.0)/n);
            System.out.printf("(c=%2d):%12.9f  ",c,p);
        }
        System.out.printf("\n");
    }

  }
}