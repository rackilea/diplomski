private Mat bufferedImageToMat(BufferedImage inBuffImg) 
{
    BufferedImage image = new BufferedImage(inBuffImg.getWidth(), inBuffImg.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
    Graphics2D g2d= image.createGraphics();
    g2d.drawImage(inBuffImg, 0, 0, null);
    g2d.dispose();

    Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
    byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
    mat.put(0, 0, data);

    return mat;
}