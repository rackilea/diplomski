public static String getChristmassTree(int size) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
        sb.append(" ".repeat(size - i));
        sb.append("*".repeat(Math.max(0, (2 * i + 1))));
        sb.append("\n");
    }
    sb.append(" ".repeat(Math.max(0, size)));
    sb.append("**");
    return sb.toString();
}