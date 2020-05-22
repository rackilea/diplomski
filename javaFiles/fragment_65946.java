public boolean isInsideLine(int x1, int y1, int x2, int y2) {
    final int dx = abs(x2 - x1), dy = abs(y2 - y1);
    final int sx = x1 < x2 ? 1 : -1, sy = y1 < y2 ? 1 : -1;
    int err = dx - dy;

    while (true) {
        if (isInside(x1, y1)) //Lookup in pixel array
            return true;
        if (x1 == x2 && y1 == y2)
            break;
        final int e2 = err << 1;
        if (e2 > -dy) {
            err -= dy;
            x1 += sx;
        } else if (e2 < dx) { // else if instead of if
            err += dx;
            y1 += sy;
        }
    }
    return false;
}