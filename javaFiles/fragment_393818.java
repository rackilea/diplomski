public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    graphics = image.getGraphics();
    ((Graphics2D) graphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    ((Graphics2D) graphics).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    render.setRenderState((Graphics2D) graphics);
}