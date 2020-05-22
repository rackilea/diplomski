final int width = image.getWidth();
int[] imgData = new int[width];
int[] maskData = new int[width];

for (int y = 0; y < image.getHeight(); y++) {
    // fetch a line of data from each image
    image.getRGB(0, y, width, 1, imgData, 0, 1);
    mask.getRGB(0, y, width, 1, maskData, 0, 1);
    // apply the mask
    for (int x = 0; x < width; x++) {
        int color = imgData[x] & 0x00FFFFFF; // mask away any alpha present
        int maskColor = (maskData[x] & 0x00FF0000) << 8; // shift red into alpha bits
        color |= maskColor;
        imgData[x] = color;
    }
    // replace the data
    image.setRGB(0, y, width, 1, imgData, 0, 1);
}