public static String[] split(String input, String delimiters) {
    String[] array;
    if (input == null) {
        input = "";
    }
    if (input.length() == 0) {
        array = new String[1];
        array[0] = "";
        return array;
    }

    if (delimiters == null) {
        delimiters = "";
    }

    StringTokenizer tok = new StringTokenizer(input, delimiters);
    int count = tok.countTokens();
    array = new String[count];
    int i = 0;
    while (tok.hasMoreTokens()) {
        array[i++] = tok.nextToken();
    }
    return array;
}