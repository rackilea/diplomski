@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    for (PaintableEntity entity : entities) {
        entity.paint(g2d, spriteEngine.getCycleProgress());
    }
    g2d.dispose();
}