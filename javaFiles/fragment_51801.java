try {
    BufferedImage image = ImageIO.read(new File("resources/Tulips.jpg"));
    BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(),
            BufferedImage.TYPE_INT_ARGB);

    int newColorRGB = new Color(255, 0, 0).getRGB();
    for (int x = 0; x < image.getWidth(); x++) {
        for (int y = 0; y < image.getHeight(); y++) {
            Color color = new Color(image.getRGB(x, y));
            int red = color.getRed();
            int blue = color.getBlue();
            int green = color.getGreen();

            if (red == 50 && blue == 50 && green == 50) {
                newImage.setRGB(x, y, newColorRGB);
            } else {
                newImage.setRGB(x, y, color.getRGB());
            }
        }
    }
    ImageIO.write(newImage, "png", new File("resources/Tulips1.png"));
} catch (IOException e) {
    e.printStackTrace();
    System.out.println("Sorry, I cannot find that file.");
}