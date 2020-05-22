String patternString = "[{][{](?<id>.*)[}][}]";
// String patternString = "\\{\\{(?<id>[^}]+)}}";
Pattern pattern = Pattern.compile(patternString);
Matcher matcher = pattern.matcher(string);
List<String> allMatches = new ArrayList<>();
while (matcher.find()) {
    allMatches.add(matcher.group("id"));
}