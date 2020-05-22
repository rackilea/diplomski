public void activateAll() {
    for (Ellipse2D ellipse : ellipses) {
        ellipseColorMap.put(ellipse, ACTIVE_COLOR);
    }
    repaint();
}