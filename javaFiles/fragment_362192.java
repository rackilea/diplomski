public static JButton createImageButton(ImageIcon image) {
    JButton btn = new JButton(image);
    btn.setContentAreaFilled(false);
    btn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    btn.setPressedIcon(new ImageIcon(generatePressedDarkImage(image.getImage())));
    return btn;
}

private static Image generatePressedDarkImage(final Image image) {
    final ImageProducer prod = new FilteredImageSource(image.getSource(), new RGBImageFilter() {

        @Override
        public int filterRGB(int x, int y, int rgb) {
            final int red = (rgb >> 16) & 0xff;
            final int green = (rgb >> 8) & 0xff;
            final int blue = rgb & 0xff;
            final int gray = (int)((0.30 * red + 0.59 * green + 0.11 * blue) / 4);

            return (rgb & 0xff000000) | (grayTransform(red, gray) << 16) | (grayTransform(green, gray) << 8) | (grayTransform(blue, gray) << 0);
        }

         private int grayTransform(final int color, final int gray) {
                int result = color - gray;
                if (result < 0) result = 0;
                if (result > 255) result = 255;
                return result;
        }
    });
    return Toolkit.getDefaultToolkit().createImage(prod);
}