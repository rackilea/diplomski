private final static int ADVANCE = 16;

public void paint(Graphics g) {
    int x = 10;
    if (pickA) {
        g.drawString("a", x, 10);
        x += ADVANCE;
    }
    if (pickB) {
        g.drawString("b", x, 10);
        x += ADVANCE;
    }
    // ...
}