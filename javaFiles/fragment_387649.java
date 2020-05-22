List<String> matchList = new ArrayList<String>();
Pattern regex = Pattern.compile(".{1,50}(?:\\s|$)", Pattern.DOTALL);
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    matchList.add(regexMatcher.group());
}