public boolean typeMatch(char c1, char c2) {
    String[] pairs = { "{}", "()", "[]" };
    for (String pair : pairs) {
        if (pair.indexOf(c1) != -1) {
            return pair.indexOf(c2) != -1;
        }
    }
    return false;
}