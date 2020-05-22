// size is the pixel width/height of a square.
// multiples is the number of black/white pairs to draw.
// x,y are the screen position of the top left corner.
// offset is the amount to offset by.
public static void grid(Graphics g, int size, int multiples, int x, int y, int offset) {
    for (int i = 0; i < multiples * 2; i++) {
        row(g, size, multiples, x + (offset * i), y + (size * i) + (2 * i));
    }
}