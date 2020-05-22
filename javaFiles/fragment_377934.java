public static Rectangle getVirtualScreenBounds() {

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice lstGDs[] = ge.getScreenDevices();

    Rectangle bounds = new Rectangle();
    for (GraphicsDevice gd : lstGDs) {

        bounds.add(gd.getDefaultConfiguration().getBounds());

    }

    return bounds;

}