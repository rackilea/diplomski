public BufferedImage readImage(String imageUrl) throws IOException, ImageReadException {

    /* some code omitted */

    URL url = new URL(imageUrl;
    ImageInputStream stream = ImageIO.createImageInputStream(url.openStream());