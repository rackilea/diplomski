for (int i = 255; i > 0; i--) {
    float h;
    float s;
    float v;
    if (i > 230) {
        h = 0;      // gray
        s = 0;
        v = 1f * i / 255;
    } else if (i <= 230 && i > 180) {
        h = 0.1;   // brown
        s = 0.8;
        v = 1f * (230 - i) / (230 - 180);
    } else if (i <= 180 && i > 79) {
        h = 0.33;  // green
        s = 1f;
        v = 1f * (180 - i) / (180 - 79);
    } else {
        h = 0.62;  // blue
        s = 1f;
        v = 1f;
    }
    g2.setColor(new Color(Color.HSBtoRGB(h, s, v)));
    g2.drawLine(0, 255 - i, 500, 255 - i);
}