public Image addTextToImage(BufferedImage i, String[] text) {

    final int VERTICLE_PADDING_PIXELS = 5;
    final int LEFT_MARGIN_PIXELS = 5;

    FontMetrics fm = i.createGraphics().getFontMetrics();

    int width = i.getWidth();
    int height = i.getHeight()
            + (text.length * (fm.getHeight() + VERTICLE_PADDING_PIXELS));

    for (String s : text) {
        width = Math.max(width, fm.stringWidth(s) + LEFT_MARGIN_PIXELS);
    }

    BufferedImage result = new BufferedImage(i.getHeight(), width, height);

    Graphics2D g = result.createGraphics();

    g.drawImage(i, 0, 0, null);

    for (int x = 0; x < text.length; x++) {
        g.drawString(text[x], LEFT_MARGIN_PIXELS, i.getHeight() + (x + 1) *VERTICLE_PADDING_PIXELS + x*fm.getHeight());
    }

    return result;
}