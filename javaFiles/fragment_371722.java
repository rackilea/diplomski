public Grid (int feldlänge) {
    grid = new Cell[feldlänge][feldlänge];
    int x, y;
    for (y = 0; y < feldlänge; y = y + 1) {
        for (x = 0; x < feldlänge; x = x + 1) {
            Cell cell;
            cell = new Cell(x,y);
            cell.setLife(false); 
            grid[x][y] = cell; //put the cell in the grid.
        } // for     
    } // for
} // Konstruktor Grid