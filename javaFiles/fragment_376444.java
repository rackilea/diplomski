String patternString = "[{][{](.*)[}][}]";
//String patternString = "\\{\\{([^}]+)}}";
Pattern pattern = Pattern.compile(patternString);
Matcher matcher = pattern.matcher(string);
List<String> allMatches = new ArrayList<>();
while (matcher.find()) {
    allMatches.add(matcher.group(1));
}