public static BufferedImage toBufferedImage(byte[] pixels, int width, int height) throws IllegalArgumentException {
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
    byte[] imgData = ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
    System.arraycopy(pixels, 0, imgData, 0, pixels.length);
    return image;
}