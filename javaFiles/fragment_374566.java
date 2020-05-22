public static byte[] extractBytes2(String ImageName) throws IOException {
    File imgPath = new File(ImageName);
    BufferedImage bufferedImage = ImageIO.read(imgPath);

    ByteOutputStream bos = null;
    try {
        bos = new ByteOutputStream();
        ImageIO.write(bufferedImage, "png", bos);
    } finally {
        try {
            bos.close();
        } catch (Exception e) {
        }
    }

    return bos == null ? null : bos.getBytes();

}