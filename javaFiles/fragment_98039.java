String url = "http://stackoverflow/java/regex";
Pattern pattern = Pattern.compile(".+/(.+/.+)$");
Pattern otherPattern = Pattern.compile(".+/(.+)/.+$");
Matcher matcher = pattern.matcher(url);
if (matcher.find()) {
    System.out.println(matcher.group(1));
}
matcher = otherPattern.matcher(url);
if (matcher.find()) {
    System.out.println(matcher.group(1));
}