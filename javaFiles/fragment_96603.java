private static Float toFloat(Float def, String str) {
    try {
        return str != null ? Float.valueOf(str) : def;
    } catch (NumberFormatException e) {
        return def;
    }
}