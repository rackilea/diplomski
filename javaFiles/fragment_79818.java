for (int x = 0; x < img1.getWidth(); x++) {
    for (int y = 0; y < img1.getHeight(); y++) {
        if (img1.getRGB(x, y) != img2.getRGB(img1.getHeight() - 1 - y, x))
            return false;
    }
}