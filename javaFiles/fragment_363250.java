public static void main(String[] args) {
    GraphicsEnvironment ge
            = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    boolean isPerPixelTranslucencySupported
            = gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);

    if (!isPerPixelTranslucencySupported) {
        System.out.println("Per-pixel translucency is not supported");
        System.exit(0);
    }

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            SwingIt gtw = new SwingIt();
            gwt.runn();
            gtw.setVisible(true);
        }
    });
}