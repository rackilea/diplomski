private static void print(Component comp) {
    // Create a `BufferedImage` and create the its `Graphics`
    BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice().getDefaultConfiguration()
            .createCompatibleImage(comp.getWidth(), comp.getHeight());
    Graphics graphics = image.createGraphics();
    // Print to BufferedImage
    comp.paint(graphics);
    graphics.dispose();
    // Output the `BufferedImage` via `ImageIO`
    try {
        ImageIO.write(image, "png", new File("Image.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
}