try {
    BufferedImage img = ImageIO.read(...);

    for (int x = 0; x < img.getWidth(); x++) {
        for (int y = 0; y < img.getHeight(); y++) {
            int rgb = img.getRGB(x, y);
            System.out.println(rgb + " = " + new Color(rgb, true));
        }
    }
} catch (IOException ex) {
    ex.printStackTrace();
}