@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int w = getWidth();
    int h = getHeight();
    final Graphics2D g2 = (Graphics2D) g;
    GradientPaint gp = new GradientPaint(-w, -h, Color.LIGHT_GRAY, w, h, Color.DARK_GRAY);
    g2.setPaint(gp);
    g2.fillRect(0, 0, w, h);
    for (int i = 0; i < lightcells.size(); i++) {
        LightCell cell = lightcells.get(i);
        cell.process(g2);
    }
}