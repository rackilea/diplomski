public static String normalizeText(String s) {
    s = s.replace(" ", "");
    s = s.replace("(","");
    // your other replacements

    s = s.toUpperCase();

    return s;
}