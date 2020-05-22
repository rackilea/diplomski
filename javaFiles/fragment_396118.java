final BufferedImage in = ImageIO.read(new File("frabozzle.tif"));
final BufferedImage out = new BufferedImage(
    in.getWidth(), in.getHeight(),
    BufferedImage.TYPE_BYTE_GRAY);
out.getGraphics().drawImage(in, 0, 0, null);
ImageIO.write(out, "TIFF", new File("graybozzle.tif"));