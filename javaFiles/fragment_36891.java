public static char[][] ComputerPlays( char[][] M ) {
   System.out.println("Computer selects grid position...");
   int pos, x, y;
   do {
      pos = (int)(Math.random() * 9); // Roll a new position.
      x = ( pos / 3 )*2 + 1;
      y = ( pos % 3 )*2 + 1;
   } while ( occupied( M[x][y] ) ); // Repeat as long as the position is occupied.
   M[x][y] = 'O';
   return M;
} //end ComputerPlays