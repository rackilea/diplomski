void floodFill( int x, int y ) {
   if ( btn( x, y ) isFillable ) {
       fillBtn(x,y);
       floodFill( x+1, y );
       floodFill( x-1, y );
       floodFill( x, y-1 );
       floodFill( x, y+1 );
   } else {
       return;
   }
}