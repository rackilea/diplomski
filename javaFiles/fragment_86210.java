public static int[][] reshuffle(int[][] board) {
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;

    for(int i=0;i<4;i++) {
       for (int j = 0; j < 14; j++) {
           if (i==0 && board[i][j] + 1 != board[0][j + 1]) {
               count1 = j+1;
               break;
           } else if (i==1 && board[i][j] + 1 != board[1][j + 1]) {
               count2 = j+1;
               break;
            } else if (i==2 && board[i][j] + 1 != board[2][j + 1]) {
                count3 = j+1;
                break;
             } else if (i==3 && board[i][j] + 1 != board[3][j + 1]) {
                count4 = j+1;
                break;
             }
        }   
    }
}