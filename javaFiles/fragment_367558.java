public static BufferedImage transformImage(BufferedImage image, AffineTransform transform) throws Exception {

    AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);

    BufferedImage destinationImage = op.createCompatibleDestImage(image, (image.getType() == BufferedImage.TYPE_BYTE_GRAY) ? image.getColorModel() : null );
    Graphics2D g = destinationImage.createGraphics();
    g.setBackground(Color.WHITE);
    g.clearRect(0, 0, destinationImage.getWidth(), destinationImage.getHeight());
    destinationImage = op.filter(image, destinationImage);
    return destinationImage;
}