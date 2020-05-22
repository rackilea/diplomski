private static boolean isParseable(String str) {
    try {
        Double.parseDouble(str);
        return true;
    } catch(NumberFormatException e) {
        return false;
    }
}