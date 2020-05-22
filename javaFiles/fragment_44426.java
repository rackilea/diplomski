public void mouseWheelMoved(MouseWheelEvent e) {
    int notches = e.getWheelRotation();

    // Get the current/old size...    
    double oldWidth = image.getWidth() * scaleFactor;
    double oldHeight = image.getHeight() * scaleFactor;

    scaleFactor = scaleFactor + notches / 10.0;
    if (scaleFactor < 0.5) {
        scaleFactor = 0.5;
    } else if (scaleFactor > 3.0) {
        scaleFactor = 3.0;
    }
    // Get the new size
    double newWidth = image.getWidth() * scaleFactor;
    double newHeight = image.getHeight() * scaleFactor;

    // Calculate the difference (and divide it by 2)
    double difWidth = (oldWidth - newWidth) / 2;
    double difHeight = (oldHeight - newHeight) / 2;

    // Add it to the image position...
    imageX += difWidth;
    imageY += difHeight;

    revalidate();
    repaint();
}