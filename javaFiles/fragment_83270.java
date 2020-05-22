public static Boolean valueOf(boolean b) {
    return (b ? TRUE : FALSE);
}

public static Boolean valueOf(String s) {
    return toBoolean(s) ? TRUE : FALSE;
}