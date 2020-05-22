class Board {
    public static final int ROWS = 8;
    public static final int COLS = ROWS;
    private BoardSpace[][] grid = new BoardSpace[ROWS][COLS];

    public Board() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                MyColor color = row % 2 == col % 2 ? MyColor.BLACK : MyColor.WHITE;
                grid[row][col] = new BoardSpace(color, col, row, false);
            }
        }
    }

    public BoardSpace getBoardSpace(int x, int y) {
        // to get color, simply call getColor() on this
        return grid[y][x];
    }

}