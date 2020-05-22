public void changeColor(BufferedImage img, Color old, Color new) {
    final int oldRGB = old.getRGB();
    final int newRGB = new.getRGB();
    for (int x = 0; x < img.getWidth(); x++) {
        for (int y = 0; y < img.getHeight(); y++) {
            if (img.getRGB(x, y) == oldRGB)
                img.setRGB(x, y, newRGB);
        }
    }
}