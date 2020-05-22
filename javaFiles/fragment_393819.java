public void paintComponent(Graphics panelG2d) {
    super.paintComponent(panelG2d);

    Graphics2D imageG2d = (Graphics2D) image.getGraphics();

    imageG2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    imageG2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    render.setRenderState(imageG2d);

    panelG2d.drawImage(image, 0, 0, this);
}