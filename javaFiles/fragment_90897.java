public static String columnName(int index) {
    StringBuilder s = new StringBuilder();
    while (index >= 26) {
        s.insert(0, (char) ('A' + index % 26));
        index = index / 26 - 1;
    }
    s.insert(0, (char) ('A' + index));
    return s.toString();
}