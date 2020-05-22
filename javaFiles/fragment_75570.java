public static int aliveneighbors(int[][] board, int x, int y){
    int width = board.length;
    int height = board[0].length;
    int count = 0;


    boolean isNotLower =  (y-1) >= 0;
    boolean isNotUpper = (y+1) < height;

    if (x-1 >= 0) {

       if( isNotLower && (board[x-1][y-1] == 1) )
        count++;
       if(board[x-1][y] == 1)
        count++;
       if(isNotUpper && (board[x-1][y+1] == 1) )
        count++;            
    }

    if (x+1 < width) {
       if( isNotLower && (board[x+1][y-1] == 1) )
        count++;
       if(board[x+1][y] == 1)
        count++;
       if( isNotUpper && (board[x+1][y+1] == 1) )
        count++;            
    }

    if( isNotUpper && (board[x][y+1] == 1) )
        count++;
    if(isNotLower && (board[x][y-1] == 1) )
        count++;

     return count;
}