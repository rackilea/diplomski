public static class MyBorderLayout extends BorderLayout {
    Color[] colors = new Color[] {Color.RED, Color.BLUE, Color.GREEN, Color.CYAN, Color.MAGENTA};
    public void paintDebug(Container parent) {
        Graphics g = parent.getGraphics();

        for (int i = 0; i < parent.getComponentCount(); i++) {
            Component child = parent.getComponents()[i];
            g.setColor(colors[i % colors.length]);
            Rectangle r = child.getBounds();
            g.drawRect(r.x, r.y, r.width, r.height);
        }
    }
}