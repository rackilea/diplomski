// Take another parameter i.e. threshold
public static Image makeColorTransparent(BufferedImage im, final Color color, float threshold) {
    ImageFilter filter = new RGBImageFilter() {
        public float markerAlpha = color.getRGB() | 0xFF000000;
        public final int filterRGB(int x, int y, int rgb) {
            int currentAlpha = rgb | 0xFF000000;           // just to make it clear, stored the value in new variable
            float diff = Math.abs((currentAlpha - markerAlpha) / markerAlpha);  // Now get the difference
            if (diff <= threshold) {                      // Then compare that threshold value
                return 0x00FFFFFF & rgb;
            } else {
                return rgb;
            }
        }
    };
    ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
    return Toolkit.getDefaultToolkit().createImage(ip);
}