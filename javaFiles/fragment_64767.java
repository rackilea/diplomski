/*
 * Where bi is your image, (x0,y0) is your upper left coordinate, and (w,h)
 * are your width and height respectively
 */
public static Color averageColor(BufferedImage bi, int x0, int y0, int w,
        int h) {
    int x1 = x0 + w;
    int y1 = y0 + h;
    long sumr = 0, sumg = 0, sumb = 0;
    for (int x = x0; x < x1; x++) {
        for (int y = y0; y < y1; y++) {
            Color pixel = new Color(bi.getRGB(x, y));
            sumr += pixel.getRed();
            sumg += pixel.getGreen();
            sumb += pixel.getBlue();
        }
    }
    int num = w * h;
    return new Color(sumr / num, sumg / num, sumb / num);
}