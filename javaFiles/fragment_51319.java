public FullScreenFrame() {
    addKeyListener(this);

    GraphicsDevice gd =
            GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    if (gd.isFullScreenSupported()) {
        setUndecorated(true);
        gd.setFullScreenWindow(this);
    } else {
        System.err.println("Full screen not supported");
        setSize(100, 100); // just something to let you see the window
        setVisible(true);
    }
}