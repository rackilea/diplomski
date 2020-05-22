private void moveVertex(int x1, int y1) {
    int OFFSET = 1;
    if ((x != x1) || (y != y1)) {
        x = x1 - 10;
        y = y1 - 10;
        repaint();
    }
}