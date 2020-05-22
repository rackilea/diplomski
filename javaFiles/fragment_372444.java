private void revealZeros(int x, int y) {
        if (x < 0 || x > 15 || y < 0 || y > 15) return; // check for bounds

           if ( board[y][x].b == 0 && !board[y][x].revealed) {
               board[y][x].revealed = true;
               revealZeros( x+1, y );
               revealZeros( x-1, y );
               revealZeros( x, y-1 );
               revealZeros( x, y+1 );
           } else {
               return;
           }
        }