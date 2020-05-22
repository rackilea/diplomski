SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        final BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        frame.paintAll(g2d);
        g2d.dispose();
        ImageIO.write(image, "png", new File("output.png"));
    }
});