XO board[][] = new XO[3][3];
for(int i = 0; i < board.length; i++)
    for(int j = 0; j < board[i].length; j++)
        board[i][j] = new XO();

System.out.println(board[1][1]);