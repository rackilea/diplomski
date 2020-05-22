private static final int[][] BOARD1 = <array here>;
 private static final int[][] BOARD2 = <array here>;
 private static final int[][] BOARD3 = <array here>;
 private static final int[][] BOARD4 = <array here>;


 public function int[][] loadBoard( int choice ) {
   switch( choice ) {
      case 1: return BOARD1;
      case 2: return BOARD2;
      case 3: return BOARD3;
      case 4: return BOARD4;
      default: throw new RuntimeException( "Unknown board choice" );
   }
 }