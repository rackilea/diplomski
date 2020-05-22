public void drawImage(Graphics g,double x, double y, int image) {
    int px = (int)((x - scrollx) * TILEWIDTH);
    int py = (int)((y - scrolly) * TILEHEIGHT);
    int sx = (image%20) * TILEWIDTH;
    int sy = TILEHEIGHT * (image/20);
    g.drawImage(sourceImage, px, py, px + TILEWIDTH,
            py + TILEHEIGHT, sx, sy, sx + TILEWIDTH, sy + TILEHEIGHT,
            null);
}