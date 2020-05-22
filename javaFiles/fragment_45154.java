public class BoundedPower extends Power {

  public static final double MAX_X = 1000000;

  BoundedPower(double x) {
    super(x);
  }

   public double powN(int n) {

     if (x.getX() > MAX_X) {
      return 0;
     } else {
      return super.powN(n);
     }
   }

   public static void main(String[] args) {

   BoundedPower bp = new BoundedPower(5);
   double test = bp.powN(4);
   System.out.println(test);
 }
}