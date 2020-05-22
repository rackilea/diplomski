public static int parseInt(String s) throws NumberFormatException {
    return parseInt(s, 10);
}

public static Integer valueOf(String s, int radix) throws NumberFormatException {
    return Integer.valueOf(parseInt(s, radix));
}

public static Integer valueOf(String s) throws NumberFormatException {
    return Integer.valueOf(parseInt(s, 10));
}