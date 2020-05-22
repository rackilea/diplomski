// This is where you need to get the size of the font
FontMetrics fm = graphSettings.getFontMetrics();
int fontAscent = fm.getAscent();

for (DrawnString s : strings) {
    Point p = s.getPosition();
    // Draw with 2px padding, for example:
    graphSettings.drawString(s.getText(), p.x + 2, p.y + fontAscent + 2);
}