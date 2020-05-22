/**
 * copy the given image to a writeable image
 * @param image
 * @return a writeable image
 */
public static WritableImage copyImage(Image image) {
    int height = (int) image.getHeight();
    int width = (int) image.getWidth();
    PixelReader pixelReader = image.getPixelReader();
    WritableImage writableImage = new WritableImage(width, height);
    PixelWriter pixelWriter = writableImage.getPixelWriter();

    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            Color color = pixelReader.getColor(x, y);
            pixelWriter.setColor(x, y, color);
        }
    }
    return writableImage;
}