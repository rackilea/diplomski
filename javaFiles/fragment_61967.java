public void render(int[][] cells) {

    int cellHeight = image.getHeight() /  cells.length;
    int cellWidth = image.getWidth() /  cells[0].length;

    for (int y = 0; y < cells.length; y++) {
        for (int x = 0; x < cells[y].length; x++) {

            int col = colors[cells[y][x]].getRGB();
            fillSquare(x * (cellWidth), y * (cellHeight), cellWidth, cellHeight, col);
        }
    }
}

// Could pass a java.awt.Rectangle here
private void fillSquare(int xPos, int yPos, int width, int height, int col) {
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            pixels[(x + xPos) + (y + yPos) * image.getWidth()] = col;
        }
    }
}

@Override
public void paint(Graphics g) {
    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
}