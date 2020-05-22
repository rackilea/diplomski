private static boolean sCompare(String s1, String s2) {
    return discombobulate(s1).equals(discombobulate(s2));
}

private static String discombobulate(String s) {
    String REGEX = "\\(s\\)|s$";

    return s.replaceAll(REGEX, "")
            .toLowerCase();
}