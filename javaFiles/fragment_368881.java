Rectangle2D[][] grid = new Rectangle2D[rows][cols];
for (int i = 0; i < grid.length; i++) {
    int y = i * CELL_SIZE;
    for (int j = 0; j < grid[i].length; j++) {
        int x = j * CELL_SIZE;
        grid[i][j] = new Rectangle2D.Double(x, y, cellSize, cellSize);
    }
}