public static Image loadImageFromRegion(Image original, Rectangle region) {

    ImageData originalImageData = original.getImageData();

    ImageData data = new ImageData(region.width, region.height, originalImageData.depth, originalImageData.palette);
    int[] pixels = new int[region.width];
    byte[] alphas = new byte[region.width];

    for (int y = 0; y < region.height; y++) {
        originalImageData.getAlphas(region.x, region.y + y, region.width, alphas, 0);
        originalImageData.getPixels(region.x, region.y + y, region.width, pixels, 0);

        data.setPixels(0, y, region.width, pixels, 0);
        data.setAlphas(0, y, region.width, alphas, 0);
    }

    return new Image(Display.getCurrent(), data);
}