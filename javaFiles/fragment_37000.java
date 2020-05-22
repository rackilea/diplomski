BufferedImage image = new BufferedImage(getWidth(), getHeight(),
        BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = image.createGraphics();
    try {
        pdfRenderer.renderPageToGraphics(pageNumber, g2, (float) scale, (float) scale);
    } finally {
        g2d.dispose();
    }