public static Rectangle getScreenViewableBounds() {

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();

    Rectangle bounds = new Rectangle(0, 0, 0, 0);

    if (gd != null) {

        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        bounds = gc.getBounds();

        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);

        bounds.x += insets.left;
        bounds.y += insets.top;
        bounds.width -= (insets.left + insets.right);
        bounds.height -= (insets.top + insets.bottom);

    }

    return bounds;

}