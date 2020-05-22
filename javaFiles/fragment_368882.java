for (Rectangle2D[] rects : imageGrid) {
    for (Rectangle2D rect : rects) {
        if (imageArea.contains(rect)) {
            g2.drawRect((int) rect.getX(), (int) rect.getY(),
                    (int) rect.getWidth(), (int) rect.getHeight());
        }
    }
}