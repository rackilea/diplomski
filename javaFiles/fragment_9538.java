public static String getColorName(final int hsbH, final int hsbB, final int hsbS) {
    NavigableMap<Integer, String> colorRanges = new TreeMap<Integer, String>();
    colorRanges.put(0, "Red");
    colorRanges.put(15, "Orange");
    colorRanges.put(75, "Yellow");
    //...
    return colorName(hsbB, hsbS, colorRanges.floorEntry(hsbH).getValue());
}