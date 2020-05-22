BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),    BufferedImage.TYPE_INT_RGB);
//bufferedImage is the RenderedImage to be written
Graphics2D g2 = bufferedImage.createGraphics();
g2.drawImage(image, null, null);

ByteArrayOutputStream outStream = new ByteArrayOutputStream();
ImageIO.write(bufferedImage, "jpg", outStream); 
InputStream is = new ByteArrayInputStream(outStream.toByteArray());