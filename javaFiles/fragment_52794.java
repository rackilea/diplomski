public void drawThatText(Graphics g, String s, int x, int y) {
                         ^^^^^^^^^^^
                       will equal null

    g.drawString(s, x, y);
    ^
    |
    '--- Will throw a NullPointerException

}