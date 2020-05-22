BufferedImage image = new BufferedImage(rawImage.width, rawImage.height,
            BufferedImage.TYPE_INT_ARGB);

    int index = 0;
    int IndexInc = rawImage.bpp >> 3;
    for (int y = 0 ; y < rawImage.height ; y++) {
        for (int x = 0 ; x < rawImage.width ; x++) {
            int value = rawImage.getARGB(index);
            index += IndexInc;
            image.setRGB(x, y, value);