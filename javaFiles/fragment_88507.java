AffineTransform af = new AffineTransform();
af.scale(scaleFactor, scaleFactor);

AffineTransformOp operation = new AffineTransformOp(af, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
bufferedThumb = operation.filter(bufferedImage, null);
return bufferedThumb;