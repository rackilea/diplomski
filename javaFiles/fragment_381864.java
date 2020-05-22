private GImage createTexture(String importedImage, int width, int height) {
    Image importResult = getImage(getCodeBase(), importedImage);
    GImage textureResult = new GImage(importResult);
    textureResult.setSize(width, height);
    return textureResult;
}