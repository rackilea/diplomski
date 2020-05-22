WritableImage writableImage = new WritableImage(image.getPixelReader(), (int) image.getWidth(), (int) image.getHeight());
PixelWriter pixelWriter = writableImage.getPixelWriter();
PixelReader pixelReader = writableImage.getPixelReader();
for (int i = 0; i < writableImage.getHeight(); i++) {
    for (int j = 0; j < writableImage.getWidth(); j++) {
        Color c = pixelReader.getColor(j, i);
        if (c.getOpacity() < 1) {
            pixelWriter.setColor(j, i, Color.WHITE);
        }
        if (c.getRed() > 0 || c.getGreen() > 0 || c.getBlue() > 0) {
            pixelWriter.setColor(j, i, Color.BLACK);
        }
    }
}
ImageView imageView = new ImageView(writableImage);