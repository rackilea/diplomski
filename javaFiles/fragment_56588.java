public void copyImage(Image image) {
    if (image != null) {
        // don't change the width/height of your original image
        int width = image.getWidth(null);
        // int height = image.getWidth(null);
        int height = image.getHeight(null); // *** Note change ***

        // BufferedImage bi = (BufferedImage) image;  // *** no need ***
        Graphics g = getGraphics();

        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();  // save resources
    }
}