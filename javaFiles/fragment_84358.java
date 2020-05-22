if (mines[x][y] == 0 && btn[x][y].getBackground() != Color.GRAY) {
    btn[x][y].setBackground(Color.GRAY);
    floodFill(x - 1, y);
    floodFill(x + 1, y);
    floodFill(x, y - 1);
    floodFill(x, y + 1);
} else {
    return;
}