BufferedImage oldImage = ImageIO.read(imageFile),
    newImage = new BufferedImage(dim, dim, oldImage.getType());
BufferedImageOp op = new AffineTransformOp(
    AffineTransform.getTranslateInstance(
        -(oldImage.getWidth()-dim)/2, -(oldImage.getHeight()-dim)/2),
    AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
op.filter(oldImage, newImage);
ImageIO.write(newImage, "png", imageFile);