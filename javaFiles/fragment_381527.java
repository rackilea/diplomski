if (grid[row][col]) {
    if (neighbors < 2 || neighbors > 3) {
        // 1. Any live cell with fewer than two live neighbours dies
        // 3. Any live cell with more than three live neighbours dies
        grid2[row][col] = false;
    }
    // 2. Any live cell with two or three live neighbours lives on. Does nothing.
} else if (neighbors == 3) {
    // 4. Any dead cell with exactly three live neighbours becomes a live cell.
    grid2[row][col] = true;
}