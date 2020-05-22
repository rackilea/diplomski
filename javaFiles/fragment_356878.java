public static BufferedImage componentToImage(Component component, boolean visible) {
    if (visible) {
        BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) img.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        component.paintAll(g2d);
        return img;
    } else {
        component.setSize(component.getPreferredSize());
        layoutComponent(component);
        BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TRANSLUCENT);
        CellRendererPane crp = new CellRendererPane();
        crp.add(component);
        crp.paintComponent(img.createGraphics(), component, crp, component.getBounds());
        return img;
    }
}

private static void layoutComponent(Component c) {
    synchronized (c.getTreeLock()) {
        c.doLayout();
        if (c instanceof Container) {
            for (Component child : ((Container) c).getComponents()) {
                layoutComponent(child);
            }
        }
    }
}