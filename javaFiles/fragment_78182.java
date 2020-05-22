FontMetrics fm = g2.getFontMetrics();
// create hatch marks for y axis. 
for (int i = 0; i < Y_HATCH_CNT; i++) {
    int x0 = BORDER_GAP;
    int x1 = GRAPH_POINT_WIDTH + BORDER_GAP;
    int y0 = getHeight() - (((i + 1) * (getHeight() - BORDER_GAP * 2)) / Y_HATCH_CNT + BORDER_GAP);
    int y1 = y0;
    g2.drawLine(x0, y0, x1, y1);
    String value = Integer.toString(i);
    g2.drawString(value, x0 - fm.stringWidth(value), y0 + (fm.getAscent() / 2));
}

// and for x axis
for (int i = 0; i < scores.size() - 1; i++) {
    int x0 = (i + 1) * (getWidth() - BORDER_GAP * 2) / (scores.size() - 1) + BORDER_GAP;
    int x1 = x0;
    int y0 = getHeight() - BORDER_GAP;
    int y1 = y0 - GRAPH_POINT_WIDTH;
    g2.drawLine(x0, y0, x1, y1);
    String value = Integer.toString(i);
    g2.drawString(value, x0 - (fm.stringWidth(value) / 2), y0 + fm.getAscent());
}