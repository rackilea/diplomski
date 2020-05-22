boolean r = false;
boolean g = false;
for(int y = 0; y < height; y++) {
    r = !r;
    g = r;
    for(int x = 0; x < width; x++) {
        g = !g;
        if(g) {
            g2d.setColor(Color.GRAY);
        }else {
            g2d.setColor(Color.WHITE);
        }
        g2d.drawLine(x, y, x, y);
    }
}