public static List<String> giveMe(String searchString, String input) {
    List<String> results = new ArrayList<>();
    String regex = "(?i)[\\w.|-]*" + Pattern.quote(searchString) + "[\\w.|-]*";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);

    while (matcher.find()) {
        results.add(matcher.group());
    }

    return results;
}