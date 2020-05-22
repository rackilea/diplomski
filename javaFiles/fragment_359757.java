g.setColor(Color.lightGray);
…
for (int row = 0; row < h; row++) {
    for (int col = 0; col < w; col++) {
        if ((row + col) % 2 == 0) {
            g.fillRect(col * TILE, row * TILE, TILE, TILE);
        }
    }
}