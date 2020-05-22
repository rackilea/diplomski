Arrays.sort(screens, new Comparator<GraphicsDevice>() {
    public int compare(GraphicsDevice screen1,
                       GraphicsDevice screen2) {
        Rectangle bounds1 = screen1.getDefaultConfiguration().getBounds();
        Rectangle bounds2 = screen2.getDefaultConfiguration().getBounds();
        int c = bounds1.y - bounds2.y;
        if (c == 0) {
            c = bounds1.x - bounds2.x;
        }
        return c;
    }
});