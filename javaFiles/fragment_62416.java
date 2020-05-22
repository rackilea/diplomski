public static void main(String[] args) {
  for( Quadrant q: Quadrant.values() ){
    System.out.println( q );
    System.out.println( q.xPositive() );
    System.out.println( q.yPositive() );
    System.out.println( q.signPair() );
    System.out.println( q.flipX() );
  }
  for( int x = -1; x <= 1; ++x ){
    for( int y = -1; y <= 1; ++y ){
      System.out.println( Quadrant.fromInts(x, y) );
    }
  }
}