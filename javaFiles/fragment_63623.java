public static boolean isNumber(String str) {
    try {
        double v = Double.parseDouble(str);
        return true;
    } catch (NumberFormatException nfe) {
    }
    return false;
}