public static String getValueThatIneed(String path) {
    String regex = ".*\\\\" + Pattern.quote(varContainingNameOfSpecificFolder) + "\\\\([0-9]+)\\\\.*";
    String result = path.replaceAll(regex, "$1");
    if (result.equals(path)) {
        throw new IllegalArgumentException("<" + path + "> does not contain the thin i need!");
    }
    return result;
}