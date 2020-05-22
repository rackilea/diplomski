public BufferedImage getRotatedImage(BufferedImage bufferedImage, int angle) {
     AffineTransform transform = new AffineTransform();
     transform.rotate(angle);
     AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
     bufferedImage = op.filter(bufferedImage, null);
     return bufferedImage;
}