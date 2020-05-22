BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
Graphics2D g = image.createGraphics();

//.. draw stuff ..

ImageWriter writer = ImageIO.getImageWritersByFormatName("png").next();
writer.setOutput(ImageIO.createImageOutputStream(new File("myimage.png"));
writer.write(image);