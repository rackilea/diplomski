if(/*On first iteration*/) {
    super.paintComponent(g);
} else {
    g.setColor(getBackground());
    g.fillRect(x-dx, y-dy, 500, 500);
}
g.setColor(Color.cyan);
g.fillRect(x, y, 500, 500);