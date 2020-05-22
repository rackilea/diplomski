private LinkedList<ColoredArea> background = new LinkedList<ColoredArea>();
/**
 * Vykreslí všechny položky v senamu vykreslených obrazců
 * @param g2d grafika k vykreslení
 */
public void paintShape(Graphics2D g2d) {
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
    for (ColoredArea area : background) {
        area.fill(g2d);
    }
    if (mouse != null && !block) {
        g2d.setColor(mouse_color);
        g2d.draw(mouse);
    }
    if (point!=null){
        SetPointsDialog.paintPoints(point, maxPoint, parent.getChildsSize(), g2d);
    }
}

@Override
public void paint(Graphics g) {
    paintShape((Graphics2D) g);
}

@Override
protected void paintComponent(Graphics g) {
    paintShape((Graphics2D) g);
}