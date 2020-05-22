public static int strCount(String str, String sub) {
    if (str.contains(sub)) {
        return 1 + strCount(str.replaceFirst(sub, ""), sub);
    }
    return 0;
}