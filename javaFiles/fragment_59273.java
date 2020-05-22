final int currentWidthFixed32 = Fixed32.toFP(image.getWidth());
        final int currentHeightFixed32 = Fixed32.toFP(image.getHeight());

        final int thumbnailSideFixed32 = Fixed32.toFP(thumbnailSide);

        final int scaleXFixed32 = Fixed32.div(currentWidthFixed32, thumbnailSideFixed32);
        final int scaleYFixed32 = Fixed32.div(currentHeightFixed32, thumbnailSideFixed32);

        image = image.scaleImage32(scaleXFixed32, scaleYFixed32);