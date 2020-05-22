public static int[][] parse(String text) {
    if (! text.startsWith("[[") || ! text.endsWith("]]"))
        throw new IllegalArgumentException("Invalid text: " + text);
    String[] subTexts = text.substring(2, text.length() - 2).split("\\],\\[");
    int[][] result = new int[subTexts.length][];
    for (int i = 0; i < subTexts.length; i++) {
        String[] valueTexts = subTexts[i].split(",");
        result[i] = new int[valueTexts.length];
        for (int j = 0; j < valueTexts.length; j++)
            result[i][j] = Integer.parseInt(valueTexts[j]);
    }
    return result;
}