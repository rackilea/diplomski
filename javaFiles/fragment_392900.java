public class LibMatrixTests
{
   static class LibMatrix {
      public static double dot(double[] a, double[] b) {
         double sum = 0.0;
         for (int i = 0; i < a.length; i++)
            sum += a[i] * b[i];
         return sum;
      }
      public static double[][] mul( double[][] a, double[][] b ) {
         double[][] c = new double[a.length][a[0].length];
         for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
               c[i][j] = a[i][j] * b[i][j];
         return a;
      }
   }

   public static void main( String[] args ) {
      double[]   a = { 8, 5, 6, 3, 2, 1 };
      double[]   b = { 9, 8, 4, 1, 4, 7 };
      double[][] c = { a, b };
      double[][] d = { b, a };
      double     e = LibMatrix.dot( a, b );
      double[][] f = LibMatrix.mul( c, d );
      System.out.println( e );
      for( double[] g : f ) {
         for( double h : g ) {
            System.out.print( h + ", " );
         }
         System.out.println();
      }
   }
}