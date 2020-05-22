BufferedImage bufferedImage = new BufferedImage(408, 408, BufferedImage.TYPE_INT_RGB);
// Create a graphics which can be used to draw into the buffered image
Graphics2D g2d = bufferedImage.createGraphics();
g2d.rotate(Math.toRadians(90));
List<Pixel> pixels = cacheRepo.findAll();
pixels.stream().forEach(pixel -> {
    g2d.setColor(getColorFromPixel(pixel));
    g2d.fillRect(getPos(pixel.getPosition().x), getPos(pixel.getPosition().y), 20, 20);
});
//g2d.rotate(Math.toRadians(90));
// Not sure what you're hoping to achieve here
//g2d.drawRenderedImage(bufferedImage, null);
g2d.dispose();