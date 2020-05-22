public static String removeSpaces(String test) {
    String noSpaces = "";

    for (int i = 0; i < test.length(); i++) {
        if (test.charAt(i) != ' ') {
            noSpaces += test.charAt(i);
        }
    }
    return noSpaces;
}