public static void main(String[] args) {

    try {

        BufferedImage originalImage = ImageIO.read(new File("c:\\test.jpg"));//change path to where file is located
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

        BufferedImage resizeImageJpg = resizeImage(originalImage, type, 100, 100);
        ImageIO.write(resizeImageJpg, "jpg", new File("c:\\images\\testresized.jpg")); //change path where you want it saved

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }

}

private static BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) {
    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
    g.dispose();

    return resizedImage;
}