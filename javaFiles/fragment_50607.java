BufferedImage img;
for (int i=0; i<36; i++) {
    img = ImageIo.ImageIO.read(anImageFile);
    /* Do what's needed with the image (cropping, resizing etc.) */
    ImageIO.write(img, "jpg", outputFile);
    img.flush();
    img = null;
}