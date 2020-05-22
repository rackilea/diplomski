public static void main(String[] args) {
   for( int i = 2; i <= args.length; i++ ){
      int x = Integer.parseInt( args[i-2] );
      int y = Integer.parseInt( args[i-1] );
      Quadrant q = Quadrant.fromInts(x, y);
      System.out.println("( + x + "," + y + ") in " + q + " " + q.signPair());
   }
 }