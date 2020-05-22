int longestCount = 0;
for (String dots : text.split("[^.]+")) {
    if (dots.length() > longestCount) {
        longestCount = dots.length();
    }
}