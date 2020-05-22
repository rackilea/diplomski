private byte[] rotateImage(byte[] originalImageAsBytes , double radians) throws InternalException {
ByteArrayOutputStream rotatedImageStream = null;

try {
  BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(originalImageAsBytes)); // read the original image
  AffineTransform rotationTransform = new AffineTransform();
  rotationTransform.rotate(radians, originalImage.getWidth() / 2.0 , originalImage.getHeight() / 2.0);
  AffineTransformOp rotationTransformOp = 
    new AffineTransformOp(rotationTransform , AffineTransformOp.TYPE_NEAREST_NEIGHBOR); 
  BufferedImage rotatedImage = rotationTransformOp.filter(originalImage,null); 

  rotatedImageStream = new ByteArrayOutputStream();
  ImageIO.write(rotatedImage, "jpg" , rotatedImageStream); 
} catch (IOException e) {
  throw new InternalException(e);
}
return rotatedImageStream.toByteArray();
}