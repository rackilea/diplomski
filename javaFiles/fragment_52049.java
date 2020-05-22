private static void captureImage(Component c, String fileName)
        throws IOException {
    BufferedImage img = new BufferedImage(c.getWidth(), c.getHeight(),
            BufferedImage.TYPE_INT_RGB);
    c.paint(img.getGraphics());

    ImageIO.write(img, "jpg", new File(fileName + ".jpg"));
}