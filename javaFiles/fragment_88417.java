AffineTransform tx = new AffineTransform();

// last, width = height and height = width :)
tx.translate(originalImage.getHeight() / 2,originalImage.getWidth() / 2);
tx.rotate(Math.PI / 2);
// first - center image at the origin so rotate works OK
tx.translate(-originalImage.getWidth() / 2,-originalImage.getHeight() / 2);

AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

// new destination image where height = width and width = height.
BufferedImage newImage =new BufferedImage(originalImage.getHeight(), originalImage.getWidth(), originalImage.getType());
op.filter(originalImage, newImage);