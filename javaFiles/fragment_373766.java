public static Color fromByte(byte b) {
    int red = (int) Math.round(((b & 0xE0) >>> 5) / 7.0 * 255.0);
    int green = (int) Math.round(((b & 0x1C) >>> 2) / 7.0 * 255.0);
    int blue = (int) Math.round((b & 0x03) / 3.0 * 255.0);
    return new Color(red, green, blue);
}

public static byte fromColor(Color color) {
    int red = color.getRed();
    int green = color.getGreen();
    int blue = color.getBlue();

    return (byte) (((int) Math.round(red / 255.0 * 7.0) << 5) |
                ((int) Math.round(green / 255.0 * 7.0) << 2) |
                ((int) Math.round(blue / 255.0 * 3.0)));
}