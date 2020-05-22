public void checkIfWinOrDraw(int x, int y, int player){
    int line = 0;
    for (int i = y + 1; i < 10 && matrix[x][i] == player; i++, line++);
    for (int i = y; i >= 0 && matrix[x][i] == player; i--, line++);
    if (line == 5) {
        win(player);
        return;
    }
    line = 0;
    for (int i = x + 1; i < 10 && matrix[i][y] == player; i++, line++);
    for (int i = x; i >= 0 && matrix[i][y] == player; i--, line++);
    if (line == 5) {
        win(player);
        return;
    }
    line = 0;
    for (int i = x + 1, j = y + 1; i < 10 && j < 10 && matrix[i][j] == player; i++, j++, line++);
    for (int i = x, j = y; i >= 0 && j >= 0 && matrix[i][j] == player; i--, j--, line++);
    if (line == 5) {
        win(player);
        return;
    }
    line = 0;
    for (int i = x - 1, j = y + 1; i >= 0 && j < 10 && matrix[i][j] == player; i--, j++, line++);
    for (int i = x, j = y; i < 10 && j >= 0 && matrix[i][j] == player; i++, j--, line++);
    if (line == 5) {
        win(player);
    }
}