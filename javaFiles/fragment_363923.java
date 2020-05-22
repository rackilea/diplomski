private void newCell() {
    int x = (int)(Math.random() * 4);
    int y = (int)(Math.random() * 4);
    if (cell[x][y] != 0) {
        newCell();
    } else {
        cell[x][y] = twoOrFour();
    }
}