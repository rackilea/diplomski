//original source: Sun, java/awt/Window.java, setLayersOpaque(Component, boolean)
private static void setLayersTransparent(JFrame frame) {
    JRootPane root = frame.getRootPane();
    root.setOpaque(false);
    root.setDoubleBuffered(false);

    Container c = root.getContentPane();
    if (c instanceof JComponent) {
        JComponent content = (JComponent) c;
        content.setOpaque(false);
        content.setDoubleBuffered(false);
    }
    frame.setBackground(new Color(0, 0, 0, 0));
}