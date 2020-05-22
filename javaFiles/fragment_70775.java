public class PairwiseSort {

   public static void main( String[] args ) {
      double[] timea = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
      double[] speed = {11.0, 12.0, 8.0, 13.0, 9.0, 6.0};
      double[] timeb = {1.5, 2.5, 4.0, 5.5};
      double[] speedb = {12.3, 8.5, 6.9, 7.8};

      ArrayList<Datum> data = new ArrayList<>();
      for( int i = 0; i < speed.length; i++ ) {
         data.add( new Datum( timea[i], speed[i] ) );
      }
      for( int i = 0; i < speedb.length; i++ ) {
         data.add( new Datum( timeb[i], speedb[i] ) );
      }

      data.sort( Comparator.comparing( Datum::getTime ) );
      System.out.println( data );

      Matrix abc=new Matrix(10,2);
      for( int i = 0; i < data.size(); i++ ) {
         Datum datum = data.get( i );
         abc.set( i, 0, datum.getTime() );
         abc.set( i, 1, datum.getSpeed() );

      }

   }
}

class Datum {

   double time;
   double speed;

   public Datum( double time, double speed ) {
      this.time = time;
      this.speed = speed;
   }

   public double getTime() {
      return time;
   }

   public void setTime( double time ) {
      this.time = time;
   }

   public double getSpeed() {
      return speed;
   }

   public void setSpeed( double speed ) {
      this.speed = speed;
   }

   @Override
   public String toString() {
      return "Datum{" + "time=" + time + ", speed=" + speed + '}';
   }

}

class Matrix {
   Matrix( int a, int b ) {}
   void set( int a, int b, double x ) {}
}