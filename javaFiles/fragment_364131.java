public class Power
{
   public static int square(int x)
   {
      return x*x;
   }

   public static int cube(int x)
   {
      return x*x*x;
   }

   public static int hypercube(int x)
   {
      return x*x*x*x;
   }

   public static int power(int x, int n)
   {
      if (n==2)
        return square(x);

      if(n==3)
        return cube(x);

      if(n==4)
        return hypercube(x);

      return x;
   }

   public static void main(String[] args)
   {
      int x = 6;

      System.out.println( "The square of " + x + " is: " + power(x, 2));

      System.out.println( "The cube of " + x + " is: " + power(x, 3));

      System.out.println( "The hypercube of " + x + " is: " + power(x, 4));
   }
}