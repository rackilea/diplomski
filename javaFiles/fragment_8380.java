method(GameSquare[][] board, int a, int b, otherparams passed to GameSquare constructor){
    board[a][b] = new GameSquare(params)
    board[b][a] = new GameSquare(params)
    board[15-a][15-b] = new GameSquare(params)
    board[15-b][15-a] = new GameSquare(params)
}