public static BufferedImage createResizedImage(Image original, int width,
        int height) {
    BufferedImage scaledBI = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = scaledBI.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(original, 0, 0, width, height, null);
    g.dispose();
    return scaledBI;
}