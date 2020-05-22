public static String sumchars(char c1, char c2) {
    return (char)((((int)c1 + int(c2)) + 256) % 256);
}

public static String subchars(char c1, char c2) {
    return (char)(((int)c1 - int(c2)) + 256) % 256);
}