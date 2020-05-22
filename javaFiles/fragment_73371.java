public List<Color> getColorBands(Color color, int bands) {

    List<Color> colorBands = new ArrayList<>(bands);
    for (int index = 0; index < bands; index++) {
        colorBands.add(darken(color, (double) index / (double) bands));
    }
    return colorBands;

}

public static Color darken(Color color, double fraction) {

    int red = (int) Math.round(Math.max(0, color.getRed() - 255 * fraction));
    int green = (int) Math.round(Math.max(0, color.getGreen() - 255 * fraction));
    int blue = (int) Math.round(Math.max(0, color.getBlue() - 255 * fraction));

    int alpha = color.getAlpha();

    return new Color(red, green, blue, alpha);

}