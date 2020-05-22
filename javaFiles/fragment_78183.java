FontMetrics fm = g2.getFontMetrics();
// create hatch marks for y axis. 
for (int i = 0; i < Y_HATCH_CNT; i++) {
    int x0 = BORDER_GAP;
    int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
    int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
    int y1 = y0;
    g2.drawLine(x0, y0, x1, y1);
    AffineTransform oldTransform = g2.getTransform();
    AffineTransform newTransform = new AffineTransform();
    newTransform.translate(-fm.getHeight() / 2, 0);
    newTransform.rotate(Math.toRadians(-90), x0, y0);
    g2.setTransform(newTransform);
    String value = Integer.toString(i);
    g2.drawString(value, x0 - (fm.stringWidth(value) / 2), y0 + (fm.getAscent() / 2));
    g2.setTransform(oldTransform);
}