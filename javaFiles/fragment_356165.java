for (int i = 0; i < vars.length; i++) {
    ...
    String s = names[0];
    int w = fm.stringWidth(s);
    int h = fm.getHeight() + fm.getMaxDescent();
    Point2D p = arch.getStartPoint();
    int x = (int) p.getX();
    int y = (int) p.getY();
    radians = (vars[i]) * HPI;
    g.rotate(radians, x, y);
    g.drawString(s, x - w / 2, y + h);
    g.rotate(-radians, x, y);
}