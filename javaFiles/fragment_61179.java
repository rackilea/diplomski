private static int[][][] getPixels(BufferedImage image) {
    int[][][] result = new int[height][width][4];
    for (int x = 0; x < image.getWidth(); x++) {
        for (int y = 0; y < image.getHeight(); y++) {
            Color c = new Color(image.getRGB(i, j), true);
            result[y][x][0] = c.getRed();
            result[y][x][1] = c.getGreen();
            result[y][x][2] = c.getBlue();
            result[y][x][3] = c.getAlpha();
        }
    }
}