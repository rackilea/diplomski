private int r = 5;
private int x1 = 100;
private int y1 = 100;
private int x2 = 200;
private int y2 = 500;


// elsewhere in your paintComponent method:
g.fillOval(x1, y1, 2 * r, 2 * r);
g.fillOval(x2, y2, 2 * r, 2 * r);
g.drawLine(x1 + r, y1 + r, x2 + r, y2 + r);