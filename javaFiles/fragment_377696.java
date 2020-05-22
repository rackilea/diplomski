int MAX_ROWS = ...
int MAX_COLS = ...

boolean[][] visited = new boolean[MAX_ROWS][MAX_COLS];

protected void makeMove(int row, int col) {
    if (row < 0 || row >= MAX_ROWS 
     || col < 0 || col >= MAX_COLS 
     || visited[row][col] 
     || maze[row][col] == 1)
        return;

    visited[row][col] = true;
    found = row == endRow && col == endCol;

    if (!found) {
        makeMove(row, col - 1);
        makeMove(row, col + 1);
        makeMove(row - 1, col);
        makeMove(row + 1, col);
    }
}