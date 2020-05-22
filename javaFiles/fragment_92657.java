private static String compress(String str) {
    StringBuilder compressed = new StringBuilder();
    int i = 0;
    while (i < str.length()) {
        int length = 1;
        while (i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)) {
            length++;
            i++;
        }
        compressed.append(str.charAt(i)).append(length).append('-');
        i++;
    }
    return compressed.deleteCharAt(compressed.length() - 1).toString();
}