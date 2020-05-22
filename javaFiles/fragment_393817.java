BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
ImageIO.write(convertType(eleScreenshot, BufferedImage.TYPE_3BYTE_BGR), "jpg", new File(System.getProperty(USER_DIR) + File.separator + DOWNLOADED_FILES_FOLDER + File.separator + screenName + ".jpg"));

 private BufferedImage convertType(BufferedImage eleScreenshot, int type) {
    BufferedImage bi = new BufferedImage(eleScreenshot.getWidth(), eleScreenshot.getHeight(), type);
    Graphics g = bi.getGraphics();
    g.drawImage(eleScreenshot, 0, 0, null);
    g.dispose();
    return bi;
}