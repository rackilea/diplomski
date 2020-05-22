int size = 10; // assuming a square
Cell[][] cells = new Cell[size][size];
// fill with empty cells
for (int i = 0; i < cells.length; i++) {
    for (int j = 0; j < cells[i].length; j++) {
        cells[i][j] = new Cell();
    }
}