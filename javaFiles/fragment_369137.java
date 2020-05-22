private BufferedImage rotateImage(ImageRotation imageRotation, BufferedImage bufferedImage) {
    AffineTransform affineTransform = new AffineTransform();

    if (ImageRotation.ROTATION_90.equals(imageRotation) || ImageRotation.ROTATION_270.equals(imageRotation)) {
        affineTransform.translate(bufferedImage.getHeight() / 2, bufferedImage.getWidth() / 2);
        affineTransform.rotate(imageRotation.getRotationAngle());
        affineTransform.translate(-bufferedImage.getWidth() / 2, -bufferedImage.getHeight() / 2);

    } else if (ImageRotation.ROTATION_180.equals(imageRotation)) {
        affineTransform.translate(bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);
        affineTransform.rotate(imageRotation.getRotationAngle());
        affineTransform.translate(-bufferedImage.getWidth() / 2, -bufferedImage.getHeight() / 2);

    } else {
        affineTransform.rotate(imageRotation.getRotationAngle());
    }

    AffineTransformOp affineTransformOp = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);

    BufferedImage result;

    if (ImageRotation.ROTATION_90.equals(imageRotation) || ImageRotation.ROTATION_270.equals(imageRotation)) {
        result = new BufferedImage(bufferedImage.getHeight(), bufferedImage.getWidth(), bufferedImage.getType());

    } else {
        result = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), bufferedImage.getType());
    }

    affineTransformOp.filter(bufferedImage, result);

    return result;
}