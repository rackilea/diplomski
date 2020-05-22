protected void paintComponent(Graphics g) {
    // paint chart
    if (dirty || buffer == null) {
        buffer = new BufferedImage(getWidth(), getHeight(),
                                   BufferedImage.TYPE_ING_ARGB);
        // Paint the chart onto the buffered image
        dirty = false;
    }
    b.drawImage(0, 0, buffer);
    // Draw blue box
    ...
}