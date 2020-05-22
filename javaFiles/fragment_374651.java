public static BufferedImage toBufferedImage(int[][] rawRGB) {
    int h = rawRGB.length;
    int w = rawRGB[0].length;
    BufferedImage i = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    for (int y=0; y<h; ++y) {
        for (int x=0; x<w; ++x) {
            int argb = rawRGB[y][x];
            i.setRGB(x, y, argb);
        }
    }
    return i;
}