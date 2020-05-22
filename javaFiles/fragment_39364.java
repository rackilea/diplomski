public static void main(String[] args) {
    String str = "<a href=\"$handler$&landing_url=https://foo.com/index.html\">";
    String regex = "<a href=\".*?landing_url=(.*?)\">";
    List<String> parts = evaluate(regex, str);
    System.out.println("landing_url: " + parts.get(0));
}

public static List<String> evaluate(String regex, String line) {
    List<String> result = new ArrayList<String>();
    Pattern pattern = Pattern.compile(regex);

    int count = 1;
    Matcher matcher = pattern.matcher(line);
    while (matcher.find()) {
        result.add(matcher.group(count++));
    }
    return result;
}