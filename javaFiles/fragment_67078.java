boolean intersectRect(int x1, int y1, int w1, h1, int x2, int y2, int w2, int h2) {
    return intersectRange(x1, x1+w1, x2, x2+w2)
        && intersectRange(y1, y1+h1, y2, y2+h2);
}
boolean intersectRange(int ax1, int ax2, int bx1, int bx2) {
    return Math.max(ax1, bx1) <= Math.min(ax2, bx2);
}