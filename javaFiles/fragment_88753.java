int parseWithDefault(String s, int def) {
    try {
        return Integer.parseInt(s);
    }
    catch (NumberFormatException e) {
        // It's OK to ignore "e" here because returning a default value is the documented behaviour on invalid input.
        return def;
    }
}