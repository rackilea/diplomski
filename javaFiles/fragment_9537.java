public static String getColorName() {
    getHSB(rgb);
    if (hsbH < 15)
        return colorName(hsbB, hsbS, "Red");
    if (hsbH < 45)
        return colorName(hsbB, hsbS, "Orange");
    if (hsbH < 75)
        return colorName(hsbB, hsbS, "Yellow");
    //...
}

private static String colorName(int hsbB, int hsbS, String color) {
    final boolean smallSaturation = hsbS > 0 && hsbS < 45;
    if (smallSaturation) {
        if (hsbB > 70)
            return "White/Off White";
        if (hsbB < 10)
            return "Dark " + color;
    }
    return color;
}