JPanel panel = ...
    BufferedImage image = new BufferedImage(200, 200, TYPE_INT_ARGB);
    Graphics2D gg = image.createGraphics();
    try {
        gg.translate(-100, -20);  // start point of region negated
        panel.paint(gg);
    } finally {
        gg.dispose();
    }