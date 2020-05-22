private void newCell() {
    int x ;
    int y ;
    do {
        x = (int)(Math.random() * 4);
        y = (int)(Math.random() * 4);
    } while (cell[x][y] != 0);
    cell[x][y] = twoOrFour();
}