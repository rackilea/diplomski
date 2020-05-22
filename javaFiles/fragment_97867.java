String str = "a;b&c &amp;";

Pattern pattern = Pattern.compile("&\\w+;|[^\\w]");
Matcher matcher = pattern.matcher(str);

StringBuilder sb = new StringBuilder();

while (matcher.find()) {
    String match = matcher.group();
    if (!match.matches("&\\w+;")) {
        matcher.appendReplacement(sb, "");
    } else {
        matcher.appendReplacement(sb, match);
    }
}
matcher.appendTail(sb);
System.out.println(sb.toString());