private static int countLinks(String str) {
    int total = 0;
    Pattern p = Pattern.compile("(?:http|https):\\/\\/");
    Matcher m = p.matcher(str);
    while (m.find()) {
        total++;
    }
    return total;
}