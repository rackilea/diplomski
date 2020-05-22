editPane.insertIcon(UIManager.getIcon("OptionPane.errorIcon"));
editPane.insertIcon(UIManager.getIcon("OptionPane.warningIcon"));
...
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Component view = jScrollPane.getViewport().getView();
    BufferedImage img = new BufferedImage(view.getWidth(),
        view.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D off = img.createGraphics();
    off.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    off.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    view.paint(off);
    Graphics2D on = (Graphics2D)g;
    on.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    on.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    on.drawImage(img, 0, 0, getWidth(), getHeight(), null);
}