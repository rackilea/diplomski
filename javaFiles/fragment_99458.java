public static void log(String s, int type) {
    if (type == 0)
        buffer.append(s);
    if (type == 1)
        buffer.append("SOME HEADER ").optimize(s);
}