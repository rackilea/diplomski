int imageWidth  = source.getWidth();
        int imageHeight = source.getHeight();

        double scaleX = (double)width/imageWidth;
        double scaleY = (double)height/imageHeight;
        AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
        AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

        source = bilinearScaleOp.filter(
            source,
            new BufferedImage(width, height, source.getType()));