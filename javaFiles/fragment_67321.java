public static void print(int level) {
    if (level <= 0 || level > 26) {
        return;
    }
    print(level - 1);
    System.out.println(line(level));
}

public static String line(int level) {
    String line = "";
    if (level > 0 && level <= 26) {
        line = line(level--) + (char)('A' + level);
    }
    return line;
}